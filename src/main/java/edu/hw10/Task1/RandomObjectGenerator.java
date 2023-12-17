package edu.hw10.Task1;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;
import edu.hw10.Task1.Annotations.NotNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Random;

public class RandomObjectGenerator {
    private static final Random RANDOM = new Random();

    public <T> T nextObject(Class<T> classObject, String fabricMethod)
        throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        T instance;

        if (classObject.isRecord()) {
            Class<?>[] fieldTypes = Arrays.stream(classObject.getRecordComponents())
                .map(RecordComponent::getType)
                .toArray(Class<?>[]::new);

            Object[] params = Arrays.stream(classObject.getDeclaredFields())
                .map(RandomObjectGenerator::generateValue)
                .toArray();

            instance = classObject.getDeclaredConstructor(fieldTypes).newInstance(params);
        } else {
            Constructor<T> constructor = classObject.getDeclaredConstructor();
            constructor.setAccessible(true);

            if (fabricMethod != null && !fabricMethod.isEmpty()) {
                instance = (T) classObject.getDeclaredMethod(fabricMethod).invoke(null);
            } else {
                instance = constructor.newInstance();
            }

            for (Field field : classObject.getDeclaredFields()) {
                if (field.isAnnotationPresent(Min.class) || field.isAnnotationPresent(Max.class)
                    || field.isAnnotationPresent(NotNull.class)) {
                    field.setAccessible(true);

                    field.set(instance, generateValue(field));
                }
            }
        }

        return instance;
    }

    public <T> T nextObject(Class<T> classObject)
        throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return nextObject(classObject, null);
    }

    private static Object generateValue(Field field) {
        Class<?> fieldType = field.getType();
        Object value = null;

        if (fieldType.equals(String.class) && field.isAnnotationPresent(NotNull.class)) {
            value = "simple";
        } else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
            int randMin =
                field.isAnnotationPresent(Min.class) ? field.getAnnotation(Min.class).value() : Integer.MIN_VALUE;
            int randMax =
                field.isAnnotationPresent(Max.class) ? field.getAnnotation(Max.class).value() : Integer.MAX_VALUE;

            value = RANDOM.nextInt(randMin, randMax);
        }

        return value;
    }

}
