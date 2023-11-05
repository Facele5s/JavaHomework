package edu.project2.Maze_creation;

import java.util.Random;

public class ControlledRandom extends Random {
    private static final int[][] NUMBERS = new int[][] {
        {3, 3, 1, 1, 1, 0, 2, 3, 0, 2, 1, 3, 3, 3, 1, 2, 2, 2, 3, 3},
        {2, 3, 2, 2, 2, 1, 3, 0, 3, 3, 3, 2, 3, 1, 1, 0, 3, 1, 0, 3},
        {2, 1, 2, 3, 1, 0, 2, 2, 2, 0, 0, 3, 0, 0, 1, 1, 0, 2, 3, 1}
    };

    private final int[] currentNums;
    private int index;

    public ControlledRandom(int seed) {
        currentNums = NUMBERS[seed % NUMBERS.length];
    }

    @Override
    public int nextInt() {
        if (index + 1 >= currentNums.length) {
            index = 0;
            return currentNums[index];
        } else {
            return currentNums[index++];
        }
    }

    @Override
    public int nextInt(int bound) {
        while (true) {
            int n = nextInt();
            if (n < bound) {
                return n;
            }
        }
    }
}
