package edu.project2.Maze_structure;

import edu.project2.Exceptions.WrongCellException;

public interface Labyrinth {
    boolean canGoToCell(int x, int y);

    boolean isCellCorrect(int x, int y);

    Cell getCell(int x, int y) throws WrongCellException;

    int[][] getStructure();
}
