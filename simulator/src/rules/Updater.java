package rules;

import constant.Constants;
import javafx.scene.effect.Blend;
import model.Board;

public class Updater {
    public void updateBoard(char[][] board) {
        char[][] copiedBoard = getCopiedBoard(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int whiteNum = calWhiteNum(copiedBoard, i, j);
//                System.out.println("i = " + i + ", j = " + j + ", whiteNum = " + whiteNum);
                updateLoc(board, i, j, whiteNum);
            }
        }
    }

    private char[][] getCopiedBoard(char[][] cBoard) {
        int len = cBoard.length;
        char[][] copiedBoard = new char[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                copiedBoard[i][j] = cBoard[i][j];
            }
        }
        return copiedBoard;
    }

    public void updateLoc(char[][] board, int i, int j, int whiteNum) {
        //白 = 活
        //1． 如果一个格子周围有3个格子为白，则该格子为白；
        //2． 如果一个格子周围有2个格子为白，则该格子颜色不变；
        //3． 如果一个格子周围白色格子少于2个，则该格子为黑；
        //4． 如果一个格子周围有超过3个格子为白，则该格子为黑。
        if (whiteNum > 3) {
            board[i][j] = Constants.DEAD;
        }
        if (whiteNum == 3) {
            board[i][j] = Constants.LIVE;
        } else if (whiteNum == 2) {

        } else if (whiteNum < 2) {
            board[i][j] = Constants.DEAD;
        }
    }

    public int calWhiteNum(char[][] board, int x, int y) {
        int whiteNum = 0;
        int len = board.length;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || i >= len || j < 0 || j >= len) {
                    continue;
                }
                if (i == x && j == y) {
                    continue;
                }
                if (board[i][j] == Constants.LIVE)
                    whiteNum++;
            }
        }
        return whiteNum;
    }
}
