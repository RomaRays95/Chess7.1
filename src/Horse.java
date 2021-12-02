public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = false;
        if (line != toLine && column != toColumn){
            if ((toLine >= 0 && toLine <= 7) && (toColumn >= 0 && toColumn <= 7)){
                if (((line - toLine == 2) || (toLine - line == 2)) &&
                        ((column - toColumn == 1) || (toColumn - column == 1))){
                    result = true;
                }
                else result = ((line - toLine == 1) || (toLine - line == 1)) &&
                        ((column - toColumn == 2) || (toColumn - column == 2));
            }
        }
        if (chessBoard.board[toLine][toColumn] != null) {
            if (chessBoard.board[toLine][toColumn].getColor().equals(color)) result = false;
        }
        return result;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean canAttack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return canMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }
}
