import model.Board;
import rules.Updater;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Board board = new Board();
        board.init();
        board.show();
        Updater updater = new Updater();
        updater.updateBoard(board.board);
        board.show();
        updater.updateBoard(board.board);
        board.show();
    }
}
