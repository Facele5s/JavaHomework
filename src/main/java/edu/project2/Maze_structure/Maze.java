package edu.project2.Maze_structure;

import edu.project2.Exceptions.WrongCellException;
import edu.project2.Exceptions.WrongSizeException;

public class Maze implements Labyrinth {
    private final Cell[][] grid;
    private final int width;
    private final int height;

    public Maze(int width, int height) throws WrongSizeException {
        if (width < 2 || height < 2) {
            throw new WrongSizeException(width, height);
        }

        if (width % 2 == 0) {
            this.width = width + 1;
        } else {
            this.width = width;
        }

        if (height % 2 == 0) {
            this.height = height + 1;
        } else {
            this.height = height;
        }

        grid = new Cell[this.height][this.width];

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                grid[y][x] = new Cell(x, y);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean canGoToCell(int x, int y) {
        return (x > 0 && x < width - 1 && y > 0 && y < height - 1);
    }

    @Override
    public boolean isCellCorrect(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    @Override
    public Cell getCell(int x, int y) throws WrongCellException {
        if (!isCellCorrect(x, y)) {
            throw new WrongCellException(x, y);
        }

        return grid[y][x];
    }

    @Override
    public int[][] getStructure() {
        int[][] structure = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid[y][x].isDug()) {
                    structure[y][x] = 0;
                } else {
                    structure[y][x] = 1;
                }
            }
        }

        return structure;
    }
}
