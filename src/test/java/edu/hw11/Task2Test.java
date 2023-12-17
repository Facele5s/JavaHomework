package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Замена сложения умноженем")
    public void sumToMultiplyTest()
    throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        DynamicType.Unloaded unloadedType = new ByteBuddy()
            .subclass(ArithmeticUtils.class)
            .method(ElementMatchers.named("sum"))
            .intercept(MethodDelegation.to(getClass()))
            .make();

        Class<?> dynamicType = unloadedType.load(getClass()
            .getClassLoader())
            .getLoaded();

        ArithmeticUtils newUtils = (ArithmeticUtils) dynamicType.getDeclaredConstructor().newInstance();

        assertEquals(50, newUtils.sum(10, 5));
    }

    public static int sum(int a, int b) {
        return a * b;
    }
}
