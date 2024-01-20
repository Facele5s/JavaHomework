package edu.hw10.Task1;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;
import edu.hw10.Task1.Annotations.NotNull;

public record SimpleRecord(@NotNull String simpleName, @Min(1) @Max(10) int simpleCount) {
}
