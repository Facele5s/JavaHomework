package edu.project2.maze.structure;

import edu.project2.maze.exceptions.WrongCellException;
import edu.project2.maze.exceptions.WrongSizeException;

public class Maze {
    private final Cell[][] grid;
    private final int width;
    private final int height;

    public Maze(int width, int height) throws WrongSizeException {
        validateSize(width, height);

        this.width = adjustSize(width);
        this.height = adjustSize(height);

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

    public boolean canGoToCell(int x, int y) {
        return (x > 0 && x < width - 1 && y > 0 && y < height - 1);
    }

    private boolean isCellCorrect(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    public Cell getCell(int x, int y) throws WrongCellException {
        if (!isCellCorrect(x, y)) {
            throw new WrongCellException(x, y);
        }

        return grid[y][x];
    }

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

    private int adjustSize(int size) {
        if (size % 2 == 0) {
            return size + 1;
        }

        return size;
    }

    private void validateSize(int width, int height) throws WrongSizeException {
        if (width < 2 || height < 2) {
            throw new WrongSizeException(width, height);
        }
    }
}
