package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

public class Task8 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    private final static int BOARD_SIDE = 8;

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LOGGER.info("Введите значения шахматной доски: ");
        int[][] board = new int[BOARD_SIDE][BOARD_SIDE];
        for (int i = 0; i < BOARD_SIDE; i++) {
            for (int j = 0; j < BOARD_SIDE; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        LOGGER.info(knightBoardCapture(board));

        sc.close();
    }

    public static boolean knightBoardCapture(int[][] board) {
        final int[] X_COMBINATIONS = new int[] {-2, -1, 1, 2};
        final int Y_MOD = 2;

        for (int i = 0; i < BOARD_SIDE; i++) {
            for (int j = 0; j < BOARD_SIDE; j++) {
                if (board[j][i] == 1) {
                    for (int x : X_COMBINATIONS) {
                        int y = Y_MOD / x;
                        if (onTheBoard(j + x, i + y)) {
                            if (board[i + y][j + x] == 1) {
                                return false;
                            }
                        }

                        y = -Y_MOD / x;
                        if (onTheBoard(j + x, i + y)) {
                            if (board[i + y][j + x] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    private static boolean onTheBoard(int x, int y) {
        return (x >= 0 && x < BOARD_SIDE && y >= 0 && y < BOARD_SIDE);
    }

    private Task8() {
    }

}
