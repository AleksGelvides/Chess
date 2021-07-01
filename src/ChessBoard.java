public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];
    String nowPlayer;

    public ChessBoard(String nowPlayer){
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor(){
        return nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if(checkPos(startLine) && checkPos(startColumn)){
            if(!nowPlayer.equals(board[startLine][startColumn].getColor())) return false; // Проверяет, занята ли позиция союзником и возвращает возможность перехода на эту позицию.

        }
    }
}



    public boolean checkPos (int pos) {
        return pos >= 0 && pos <= 7;
    }
}
