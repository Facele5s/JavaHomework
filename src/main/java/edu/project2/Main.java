package edu.project2;

import edu.project2.maze.creation.MazeDigger;
import edu.project2.maze.exceptions.WrongCellException;
import edu.project2.maze.exceptions.WrongSizeException;
import edu.project2.maze.structure.Cell;
import edu.project2.maze.structure.Maze;
import java.util.Random;

public class Main {
    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        try {
            Maze maze = new Maze(10, 10);
            MazeDigger digger = new MazeDigger(maze, new Random());
            MazePathFinder pathFinder = new MazePathFinder(maze);
            MazePrinter printer = new MazePrinter(maze);

            digger.digMaze();
            Cell start = maze.getCell(1, 1);
            Cell finish = maze.getCell(maze.getWidth() - 2, maze.getHeight() - 2);
            pathFinder.markPath(start, finish);
            printer.printMaze();

        } catch (WrongSizeException | WrongCellException e) {
            throw new RuntimeException(e);
        }
    }
}
