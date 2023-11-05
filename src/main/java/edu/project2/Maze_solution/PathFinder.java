package edu.project2.Maze_solution;

import edu.project2.Exceptions.WrongCellException;
import edu.project2.Maze_structure.Cell;
import java.util.List;

public interface PathFinder {
    void findPath(Cell startCell, Cell finishCell) throws WrongCellException;

    List<Cell> getNearestCells(Cell current) throws WrongCellException;
}
