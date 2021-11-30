public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column != toColumn){
            if ((toLine >= 0 && toLine <= 7) && (toColumn >= 0 && toColumn <= 7)){
                return Math.abs(toLine - line) == Math.abs(toColumn - column);
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
