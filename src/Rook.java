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
        boolean result = false;
        if ((line == toLine && column != toColumn) || (line != toLine && column == toColumn)){
            result = (toLine >= 0 && toLine <= 7) && (toColumn >= 0 && toColumn <= 7);
        }
        if (chessBoard.board[toLine][toColumn] != null) {
            if (chessBoard.board[toLine][toColumn].getColor().equals(color)) result = false;
        }
        if (!ChessPiece.way(chessBoard, line, column, toLine, toColumn)) result = false;
        return result;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canAttack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return canMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }
}


