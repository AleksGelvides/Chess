import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard("Black");
        Pawn w = new Pawn("White");
        Pawn b = new Pawn("Black");
        System.out.println("Черный делает первый ход: " + b.canMoveToPosition(chessBoard,6,2,4,2));
        System.out.println("Белый делает первый ход: " + w.canMoveToPosition(chessBoard,1,3,3,3));
        System.out.println("Черный рубит: " + b.canMoveToPosition(chessBoard,4,2,3,3));
    }
}
