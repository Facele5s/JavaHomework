package edu.project2.Maze_output;

import edu.project2.Exceptions.WrongCellException;
import edu.project2.Maze_structure.Maze;

public class MazePrinter implements Printer {
    private final Maze maze;

    public MazePrinter(Maze maze) {
        this.maze = maze;
    }

    @Override
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
