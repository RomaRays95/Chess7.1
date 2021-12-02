public class Queen extends ChessPiece{

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = false;
        if (!(line == toLine && column == toColumn)){
            if ((toLine >= 0 && toLine <= 7) && (toColumn >= 0 && toColumn <= 7)){
                if (Math.abs(toLine - line) == Math.abs(toColumn - column)) result = true;
                else result = ((line == toLine) || (column == toColumn));
            }
        }
        if (chessBoard.board[toLine][toColumn] != null) {
            if (chessBoard.board[toLine][toColumn].getColor().equals(color)) result = false;
        }
        if (!ChessPiece.way(chessBoard, line, column, toLine, toColumn)) result = false;
        return result;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public boolean canAttack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return canMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }
}
