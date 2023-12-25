package edu.project2;

import edu.project2.maze.exceptions.WrongCellException;
import edu.project2.maze.exceptions.WrongSizeException;
import edu.project2.maze.creation.ControlledRandom;
import edu.project2.maze.creation.MazeDigger;
import edu.project2.maze.structure.Cell;
import edu.project2.maze.structure.Maze;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathFinderTest {
    @Test
    @DisplayName("Проверка поиска пути, сид 0")
    public void pathFindSeed0Test() throws WrongSizeException, WrongCellException {
        Maze maze = new Maze(9, 9);

        MazeDigger digger = new MazeDigger(maze, new ControlledRandom(0));
        digger.digMaze();

        MazePathFinder pathFinder = new MazePathFinder(maze);
        Cell start = maze.getCell(1, 1);
        Cell finish = maze.getCell(maze.getWidth() - 2, maze.getHeight() - 2);
        pathFinder.markPath(start, finish);

        List<Integer> xCoordinates = List.of(
            1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 7, 7, 7
        );
        List<Integer> yCoordinates = List.of(
            1, 1, 1, 1, 1, 2, 3, 3, 3, 4, 5, 6, 7
        );

        assertEquals(xCoordinates, pathFinder.getxCoordinates());
        assertEquals(yCoordinates, pathFinder.getyCoordinates());
    }

    @Test
    @DisplayName("Проверка поиска пути, сид 1")
    public void pathFindSeed1Test() throws WrongSizeException, WrongCellException {
        Maze maze = new Maze(15, 9);

        MazeDigger digger = new MazeDigger(maze, new ControlledRandom(1));
        digger.digMaze();

        MazePathFinder pathFinder = new MazePathFinder(maze);
        Cell start = maze.getCell(1, 1);
        Cell finish = maze.getCell(maze.getWidth() - 2, maze.getHeight() - 2);
        pathFinder.markPath(start, finish);

        List<Integer> xCoordinates = List.of(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 10, 11, 11, 11, 12, 13, 13, 13
        );
        List<Integer> yCoordinates = List.of(
            1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7
        );

        assertEquals(xCoordinates, pathFinder.getxCoordinates());
        assertEquals(yCoordinates, pathFinder.getyCoordinates());
    }

    @Test
    @DisplayName("Проверка поиска пути, сид 2")
    public void pathFindSeed2Test() throws WrongSizeException, WrongCellException {
        Maze maze = new Maze(7, 13);

        MazeDigger digger = new MazeDigger(maze, new ControlledRandom(2));
        digger.digMaze();

        MazePathFinder pathFinder = new MazePathFinder(maze);
        Cell start = maze.getCell(1, 1);
        Cell finish = maze.getCell(maze.getWidth() - 2, maze.getHeight() - 2);
        pathFinder.markPath(start, finish);

        List<Integer> xCoordinates = List.of(
            1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 4, 5
        );
        List<Integer> yCoordinates = List.of(
            1, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9, 10, 11, 11, 11
        );

        assertEquals(xCoordinates, pathFinder.getxCoordinates());
        assertEquals(yCoordinates, pathFinder.getyCoordinates());
    }
}
