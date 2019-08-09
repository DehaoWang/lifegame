package model;

import constant.Constants;

public class Board {
    public char[][] board;

    public void init() {
        int size = Constants.BOARD_SIZE;
        int len = 2 * Constants.BOARD_SIZE + 1;
        board = new char[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                board[i][j] = Constants.DEAD;
            }
        }
        board[size][size] = Constants.LIVE;
        board[size - 1][size] = Constants.LIVE;
        board[size][size - 1] = Constants.LIVE;
    }

    public void show() {
        System.out.println("*** BOARD SHOW ***");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
