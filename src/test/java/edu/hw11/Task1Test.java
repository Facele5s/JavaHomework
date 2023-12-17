package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("toString override test")
    public void helloWorldToStringTest()
    throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        DynamicType.Unloaded unloadedType = new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.isToString())
            .intercept(FixedValue.value("Hello world!"))
            .make();

        Class<?> dynamicType = unloadedType.load(getClass()
            .getClassLoader())
            .getLoaded();

        assertEquals(dynamicType.getDeclaredConstructor().newInstance().toString(), "Hello world!");
    }
}
