package edu.hw10.Task1;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;
import edu.hw10.Task1.Annotations.NotNull;

public class SimpleClass {
    @NotNull
    private String simpleName;

    @Min(1)
    @Max(10)
    private int simpleCount;

    public static SimpleClass create() {
        return new SimpleClass();
    }

    public String getSimpleName() {
        return simpleName;
    }

    public int getSimpleCount() {
        return simpleCount;
    }
}
