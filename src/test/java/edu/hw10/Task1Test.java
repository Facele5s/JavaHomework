package edu.hw10;

import edu.hw10.Task1.RandomObjectGenerator;
import edu.hw10.Task1.SimpleClass;
import edu.hw10.Task1.SimpleRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    @Test
    @DisplayName("Корректность геренации объекта")
    public void generateObjectTest()
        throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        RandomObjectGenerator rog = new RandomObjectGenerator();

        SimpleClass simpleClass = rog.nextObject(SimpleClass.class, "create");
        SimpleRecord simpleRecord = rog.nextObject(SimpleRecord.class);

        assertNotNull(simpleClass);
        assertNotNull(simpleRecord);

        assertNotNull(simpleClass.getSimpleName());
        assertNotNull(simpleRecord.simpleName());

        assertFalse(simpleClass.getSimpleName().isEmpty());
        assertFalse(simpleRecord.simpleName().isEmpty());

        assertTrue(simpleClass.getSimpleCount() >= 1 && simpleClass.getSimpleCount() < 10);
        assertTrue(simpleRecord.simpleCount() >= 1 && simpleRecord.simpleCount() < 10);
    }
}
