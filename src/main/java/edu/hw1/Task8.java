package edu.hw1;

import java.util.ArrayList;
import java.util.List;

public class Task8 {
    private final static int BOARD_SIDE = 8;

    public static boolean knightBoardCapture(int[][] board) {
        final List<Knight> knights = new ArrayList<>();

        for (int i = 0; i < BOARD_SIDE; i++) {
            for (int j = 0; j < BOARD_SIDE; j++) {
                if (board[j][i] == 1) {
                    knights.add(new Knight(j, i));
                }
            }
        }

        for (Knight knight1 : knights) {
            for (Knight knight2 : knights) {
                if (knight1 != knight2) {
                    int xDifference = Math.abs(knight1.getX() - knight2.getX());
                    int yDifference = Math.abs(knight1.getY() - knight2.getY());

                    if (xDifference * yDifference == 2) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private Task8() {
    }

    private static class Knight {
        private final int x;
        private final int y;

        Knight(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
