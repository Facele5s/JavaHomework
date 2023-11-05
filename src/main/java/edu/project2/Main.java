package edu.project2;

import edu.project2.Exceptions.WrongCellException;
import edu.project2.Exceptions.WrongSizeException;
import edu.project2.Maze_creation.MazeDigger;
import edu.project2.Maze_output.MazePrinter;
import edu.project2.Maze_solution.MazePathFinder;
import edu.project2.Maze_structure.Cell;
import edu.project2.Maze_structure.Maze;
import java.util.Random;
import org.apache.logging.log4j.LogManager;

public class Main {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        try {
            Maze maze = new Maze(10, 10);
            MazeDigger digger = new MazeDigger(maze, new Random());
            MazePathFinder pathFinder = new MazePathFinder(maze);
            MazePrinter printer = new MazePrinter(maze);

            try {
                digger.digMaze();
                Cell start = maze.getCell(1, 1);
                Cell finish = maze.getCell(maze.getWidth() - 2, maze.getHeight() - 2);
                pathFinder.findPath(start, finish);
                printer.printMaze();
            } catch (WrongCellException e) {
                LOGGER.info(e);
            }
        } catch (WrongSizeException e) {
            LOGGER.info(e);
        }
    }
}
