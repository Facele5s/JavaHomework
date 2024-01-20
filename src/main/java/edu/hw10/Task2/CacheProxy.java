package edu.hw10.Task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheProxy implements InvocationHandler {
    private final Map<Method, Map<List<Object>, Object>> cache;
    private final Object object;
    private final Path directory;

    public CacheProxy(Object object, Path directory) {
        this.cache = new HashMap<>();
        this.object = object;
        this.directory = directory;
    }

    public static <T> T create(T object, Class<?> objectClass, Path directory) {
        return (T) Proxy.newProxyInstance(
            objectClass.getClassLoader(),
            objectClass.getInterfaces(),
            new CacheProxy(object, directory)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            if (!cache.containsKey(method)) {
                cache.put(method, new HashMap<>());
            }

            List<Object> argsList = Arrays.stream(args).toList();

            if (cache.get(method).containsKey(argsList)) {
                return cache.get(method).get(argsList);
            } else {
                Object result = method.invoke(object, args);

                cache.get(method).put(argsList, result);

                if (method.getAnnotation(Cache.class).persist()) {
                    try {
                        saveData(method, argsList, result);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                return result;
            }
        }

        return method.invoke(object, args);
    }

    private void saveData(Method method, List<Object> args, Object result) throws IOException {
        String fileName = method.getName() + "_" + args.toString() + ".cache";
        File file = new File(directory.toString(), fileName);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(result);
        }
    }
}
