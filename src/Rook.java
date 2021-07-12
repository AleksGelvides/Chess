public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) && (line != toLine || column != toColumn)) {
            if((chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) && moveTo(line, column, toLine, toColumn)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    private boolean moveTo(int line, int column, int toLine, int toColumn) {
        if(toLine != line && toColumn == column){
            return true;
        } else if(toLine == line && toColumn != column){
            return true;
        }
        return false;
    }
}
