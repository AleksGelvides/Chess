public class Pawn extends ChessPiece {
    private int oneStep = 0;

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (oneStep == 0 && chessBoard.checkPos(toLine) && toColumn == column) {
            oneStep++;
            return moveTo(line, column, toLine, toColumn);
        } else if (oneStep != 0 && (toLine != (line + 2) || toLine != (line - 2)) && chessBoard.checkPos(toLine) && toColumn == column) {
            return moveTo(line, column, toLine, toColumn);
        } else if (oneStep != 0 && chessBoard.checkPos(toColumn)){
            if(!chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())){
            return attack(line,column,toLine,toColumn);
            }
            return false;
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "P";
    }

    private boolean attack(int line, int column, int toLine, int toColumn) {boolean result = true;
        int[][] toPosition = new int[line][column];
        if (this.getColor().equalsIgnoreCase("black")) {
            toPosition = new int[][]{
                    {line - 1, column + 1},
                    {line - 1, column - 1},
            };
        } else if (this.getColor().equalsIgnoreCase("white")) {
            toPosition = new int[][]{
                    {line + 1, column + 1},
                    {line + 1, column - 1},
            };
        }
        for (int i = 0; i < 2; i++) {
            if (toPosition[i][0] == toLine && toPosition[i][1] == toColumn) {
                result = true;
                break;
            } else
                result = false;
        }
        return result;
    }

    private boolean moveTo(int line, int column, int toLine, int toColumn) {
        boolean result = true;
        int[][] toPosition = new int[line][column];
        if (this.getColor().equalsIgnoreCase("black")) {
            toPosition = new int[][]{
                    {line - 2, column - 0},
                    {line - 1, column - 0},
            };
        } else if (this.getColor().equalsIgnoreCase("white")) {
            toPosition = new int[][]{
                    {line + 2, column + 0},
                    {line + 1, column + 0},
            };
        }
        for (int i = 0; i < 2; i++) {
            if (toPosition[i][0] == toLine && toPosition[i][1] == toColumn) {
                result = true;
                break;
            } else
                result = false;
        }
        return result;
    }
}