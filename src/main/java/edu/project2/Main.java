package edu.project2;

import edu.project2.maze.creation.MazeDigger;
import edu.project2.maze.exceptions.WrongCellException;
import edu.project2.maze.exceptions.WrongSizeException;
import edu.project2.maze.structure.Cell;
import edu.project2.maze.structure.Maze;
import java.util.List;
import java.util.Random;

public class Main {
    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        try {
            Maze maze = new Maze(20, 20);
            MazeDigger digger = new MazeDigger(maze, new Random());
            MazePathFinder pathFinder = new MazePathFinder(maze);
            digger.digMaze();

            Cell start = maze.getCell(1, 1);
            Cell finish = maze.getCell(maze.getWidth() - 2, maze.getHeight() - 2);
            List<Cell> path = pathFinder.findPath(start, finish);

            start = maze.getCell(1, maze.getHeight() - 2);
            finish = maze.getCell(start.getX() + 2, start.getY());
            List<Cell> path1 = pathFinder.findPath(start, finish);

            MazePrinter printer = new MazePrinter(maze, List.of(path, path1));
            printer.printMaze();

        } catch (WrongSizeException | WrongCellException e) {
            throw new RuntimeException(e);
        }
    }
}
