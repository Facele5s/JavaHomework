package edu.project2;

import edu.project2.maze.exceptions.WrongCellException;
import edu.project2.maze.structure.Cell;
import edu.project2.maze.structure.Maze;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazePrinter {
    private final Maze maze;
    private List<List<Cell>> paths = null;

    public MazePrinter(Maze maze, List<List<Cell>> paths) {
        this.maze = maze;
        this.paths = paths;
    }

    public MazePrinter(Maze maze) {
        this.maze = maze;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void printMaze() throws WrongCellException {
        Set<Cell> allPathCells = combinePathCells(paths);

        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                Cell cell = maze.getCell(x, y);

                if (!cell.isDug()) {
                    System.out.print("⏹ ");
                } else {
                    if (allPathCells.contains(cell)) {
                        System.out.print("▣ ");
                    } else {
                        System.out.print("▢ ");
                    }
                }

            }
            System.out.println();
        }
    }

    private Set<Cell> combinePathCells(List<List<Cell>> paths) {
        Set<Cell> allPathCells = new HashSet<>();

        if (paths != null) {
            for (List<Cell> path: paths) {
                if (path != null && !path.contains(null)) {
                    allPathCells.addAll(path);
                }
            }
        }

        return allPathCells;
    }
}
