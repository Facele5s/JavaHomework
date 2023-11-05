package edu.project2;

import edu.project2.Exceptions.WrongCellException;
import edu.project2.Exceptions.WrongSizeException;
import edu.project2.Maze_creation.ControlledRandom;
import edu.project2.Maze_creation.MazeDigger;
import edu.project2.Maze_structure.Maze;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MazeDiggerTest {
    @Test
    @DisplayName("Проверка генерации, сид 0")
    public void digSeed0Test() throws WrongSizeException, WrongCellException {
        Maze maze = new Maze(5, 5);
        MazeDigger digger = new MazeDigger(maze, new ControlledRandom(0));
        digger.digMaze();

        int[][] expectedStructure = new int[][] {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1}
        };

        assertArrayEquals(expectedStructure, maze.getStructure());

        //

        maze = new Maze(10, 7);
        digger = new MazeDigger(maze, new ControlledRandom(0));
        digger.digMaze();

        expectedStructure = new int[][] {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        assertArrayEquals(expectedStructure, maze.getStructure());
    }

    @Test
    @DisplayName("Проверка генерации, сид 1")
    public void digSeed1Test() throws WrongSizeException, WrongCellException {
        Maze maze = new Maze(6, 6);
        MazeDigger digger = new MazeDigger(maze, new ControlledRandom(1));
        digger.digMaze();

        int[][] expectedStructure = new int[][] {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };

        assertArrayEquals(expectedStructure, maze.getStructure());

        //

        maze = new Maze(7, 9);
        digger = new MazeDigger(maze, new ControlledRandom(1));
        digger.digMaze();

        expectedStructure = new int[][] {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };

        assertArrayEquals(expectedStructure, maze.getStructure());
    }

    @Test
    @DisplayName("Проверка генерации, сид 2")
    public void digSeed2Test() throws WrongSizeException, WrongCellException {
        Maze maze = new Maze(15, 9);
        MazeDigger digger = new MazeDigger(maze, new ControlledRandom(2));
        digger.digMaze();

        int[][] expectedStructure = new int[][] {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        assertArrayEquals(expectedStructure, maze.getStructure());

        //

        maze = new Maze(11, 11);
        digger = new MazeDigger(maze, new ControlledRandom(2));
        digger.digMaze();

        expectedStructure = new int[][] {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        assertArrayEquals(expectedStructure, maze.getStructure());
    }

    @Test
    @DisplayName("Проверка на невозможность создать маленький лабиринт")
    public void smallMazeTest() {
        try {
            new Maze(0, 0);
        } catch (WrongSizeException e) {
            assertTrue(true);
        }

        try {
            new Maze(-2, 10);
        } catch (WrongSizeException e) {
            assertTrue(true);
        }
    }
}
