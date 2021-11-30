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
        if ((line == toLine && column != toColumn) || (line != toLine && column == toColumn)){
            return (toLine >= 0 && toLine <= 7) && (toColumn >= 0 && toColumn <= 7);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}


