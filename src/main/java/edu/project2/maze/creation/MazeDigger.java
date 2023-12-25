package edu.project2.maze.creation;

import edu.project2.maze.exceptions.WrongCellException;
import edu.project2.maze.structure.Cell;
import edu.project2.maze.structure.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class MazeDigger {
    private static final int[] DX = new int[] {-2, 2, 0, 0};
    private static final int[] DY = new int[] {0, 0, -2, 2};

    private final Random random;
    private final Maze maze;

    public MazeDigger(Maze maze, Random random) {
        this.maze = maze;
        this.random = random;
    }

    public void digMaze() throws WrongCellException {
        Cell current = maze.getCell(1, 1);
        Stack<Cell> cells = new Stack<>();

        while (true) {
            Cell next = getRandomNeighbour(current);

            if (next != null) {
                digCell(next);
                digCell(getMiddleCell(current, next));

                cells.push(current);
                current = next;
            } else if (!cells.isEmpty()) {
                current = cells.pop();
            } else {
                break;
            }
        }
    }

    public void digCell(Cell cell) {
        cell.dig();
    }

    public Cell getRandomNeighbour(Cell current) throws WrongCellException {
        List<Cell> availableCells = new ArrayList<>();

        for (int i = 0; i < DX.length; i++) {
            int x = current.getX() + DX[i];
            int y = current.getY() + DY[i];

            if (maze.canGoToCell(x, y)) {
                Cell cell = maze.getCell(x, y);
                if (!cell.isDug()) {
                    availableCells.add(cell);
                }
            }
        }

        if (availableCells.isEmpty()) {
            return null;
        }

        return availableCells.get(random.nextInt(availableCells.size()));
    }

    public Cell getMiddleCell(Cell cell1, Cell cell2) throws WrongCellException {
        return maze.getCell(
            (cell1.getX() + cell2.getX()) / 2,
            (cell1.getY() + cell2.getY()) / 2
        );
    }
}
