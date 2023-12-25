package edu.project2;

import edu.project2.maze.exceptions.WrongCellException;
import edu.project2.maze.structure.Maze;

public class MazePrinter {
    private final Maze maze;

    public MazePrinter(Maze maze) {
        this.maze = maze;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void printMaze() throws WrongCellException {
        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                System.out.print(maze.getCell(x, y));
            }
            System.out.println();
        }
    }
}
