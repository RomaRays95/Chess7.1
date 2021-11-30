public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column == toColumn){
            if (toLine >= 0 && toLine <= 7){
                if (color.equals("White")){
                    if (toLine - line == 1) return true;
                    else return  ((toLine - line == 2) && (line == 1));
                }
                else{
                    if (toLine - line == -1) return true;
                    else return  ((toLine - line == -2) && (line == 6));
                }
            }
        }
        return false;
    }

    public boolean canAttack (ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if ((toLine >= 0 && toLine <= 7) && (toColumn >= 0 && toColumn <= 7)){
            if (color.equals("White")){
                return  ((toLine - line == 1) && (Math.abs(toColumn - column) == 1));
            }
            else {
                return  ((toLine - line == -1) && (Math.abs(toColumn - column) == 1));
            }
        }
        else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
