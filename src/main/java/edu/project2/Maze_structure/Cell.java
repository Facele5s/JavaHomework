package edu.project2.Maze_structure;

import java.util.Objects;

public class Cell {
    private final int x;
    private final int y;
    private boolean isDug;
    private boolean isVisited;
    private boolean isPath;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDug() {
        return isDug;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public boolean isPath() {
        return isPath;
    }

    public void dig() {
        isDug = true;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void setAsPath() {
        isPath = true;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        if (!isDug) {
            return "■";
        }
        if (isPath) {
            return "▣";
        }

        return "□";
    }
}
