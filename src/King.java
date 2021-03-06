public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) && (line != toLine || column != toColumn)) {
            if ((chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) && moveTo(line, column, toLine, toColumn)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    private boolean moveTo(int line, int column, int toLine, int toColumn) {
        boolean result = true;
        int[][] toPosition = new int[][]{
                {line - 1, column - 1},
                {line + 1, column - 1},
                {line - 1, column + 1},
                {line + 1, column + 1},
                {line + 0, column + 1},
                {line + 1, column + 0},
                {line + 0, column - 1},
                {line - 1, column + 0}
        };
        for (int i = 0; i < toPosition.length; i++) {
            if (toPosition[i][0] == toLine && toPosition[i][1] == toColumn) {
                result = true;
                break;
            } else
                result = false;
        }
        return result;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        // проходка вообще по всем клеткам
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }
}
