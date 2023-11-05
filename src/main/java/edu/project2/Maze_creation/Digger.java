package edu.project2.Maze_creation;

import edu.project2.Exceptions.WrongCellException;
import edu.project2.Maze_structure.Cell;

public interface Digger {
    void digMaze() throws WrongCellException;

    void digCell(Cell cell);

    Cell getRandomCell(Cell current) throws WrongCellException;

    Cell getMiddleCell(Cell cell1, Cell cell2) throws WrongCellException;
}
