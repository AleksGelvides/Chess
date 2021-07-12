public class Horse extends ChessPiece{
    int move;
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)){   //Проверка возможности хода по доске.
            if(line != toLine && column != toColumn){   //Проверка хода на свою же позицию
                if(toPosition(line, column, toLine, toColumn)){ // Проверка на корректность хода.
                    if(chessBoard.board[line][column] == null && !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor()));    // Проверка цвета стоящей на планируемом ходу фигуры
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    private boolean toPosition(int Line, int Column, int toLine, int toColumn){
        boolean result = true;
        int[][] toPosition = new int[][]{
                {Line -2, Column -1},
                {Line -2, Column +1},
                {Line +2, Column -1},
                {Line +2, Column +1},
                {Line -1, Column -2},
                {Line -1, Column +2},
                {Line +1, Column -2},
                {Line +1, Column +2}
        };
        for(int i = 0; i < toPosition.length; i++){
            if (toPosition[i][0] == toLine && toPosition[i][1] == toColumn){
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

}
