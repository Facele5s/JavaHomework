package edu.project2;

import edu.project2.maze.exceptions.WrongCellException;
import edu.project2.maze.structure.Cell;
import edu.project2.maze.structure.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MazePathFinder {
    private final Maze maze;
    private List<Integer> xCoordinates;
    private List<Integer> yCoordinates;

    public MazePathFinder(Maze maze) {
        this.maze = maze;
    }

    public List<Integer> getxCoordinates() {
        return xCoordinates;
    }

    public List<Integer> getyCoordinates() {
        return yCoordinates;
    }

    // Поиск в ширину
    public void markPath(Cell startCell, Cell finish) throws WrongCellException {
        Cell finishCell = finish;

        Map<Cell, Cell> pathCells = new HashMap<>();
        Queue<Cell> cellsQueue = new LinkedList<>();

        startCell.setAsPath();
        pathCells.put(startCell, null);
        cellsQueue.add(startCell);

        while (!cellsQueue.isEmpty()) {
            Cell current = cellsQueue.poll();

            if (current.equals(finishCell)) {
                break;
            }

            List<Cell> nearestCells = getNearestCells(current);

            for (Cell cell : nearestCells) {
                if (!pathCells.containsKey(cell)) {
                    pathCells.put(cell, current);
                    cellsQueue.add(cell);
                }
            }
        }

        xCoordinates = new ArrayList<>();
        yCoordinates = new ArrayList<>();

        while (!startCell.equals(finishCell)) {
            finishCell.setAsPath();

            xCoordinates.add(finishCell.getX());
            yCoordinates.add(finishCell.getY());

            finishCell = pathCells.get(finishCell);
        }

        xCoordinates.add(startCell.getX());
        yCoordinates.add(startCell.getY());

        Collections.reverse(xCoordinates);
        Collections.reverse(yCoordinates);
    }

    public List<Cell> getNearestCells(Cell current) throws WrongCellException {
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};

        List<Cell> cells = new ArrayList<>();

        for (int i = 0; i < dx.length; i++) {
            int x = current.getX() + dx[i];
            int y = current.getY() + dy[i];

            if (maze.canGoToCell(x, y)) {
                Cell cell = maze.getCell(x, y);

                if (cell.isDug()) {
                    cells.add(cell);
                }
            }
        }

        return cells;
    }

}
