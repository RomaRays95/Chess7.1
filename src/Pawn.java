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
        boolean moving = false;
        if (chessBoard.board[toLine][toColumn] == null) {
            if (line != toLine && column == toColumn) {
                if (toLine >= 0 && toLine <= 7) {
                    if (color.equals("White")) {
                        if (toLine - line == 1) moving = true;
                        else {
                            moving = ((toLine - line == 2) && (line == 1) &&
                                    (chessBoard.board[toLine - 1][toColumn] == null));
                        }
                    } else {
                        if (toLine - line == -1) moving = true;
                        else {
                            moving = ((toLine - line == -2) && (line == 6) &&
                                    (chessBoard.board[toLine + 1][toColumn] == null));
                        }
                    }
                }
            }
        }

        return moving || canAttack(chessBoard, line, column, toLine, toColumn);
    }

    public boolean canAttack (ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        boolean result = false;
        if ((toLine >= 0 && toLine <= 7) && (toColumn >= 0 && toColumn <= 7)) {
            if (chessBoard.board[toLine][toColumn] != null) {
                if (!chessBoard.board[toLine][toColumn].getColor().equals(color)) {
                    if (color.equals("White")) {
                        result = ((toLine - line == 1) && (Math.abs(toColumn - column) == 1));
                    } else {
                        result = ((toLine - line == -1) && (Math.abs(toColumn - column) == 1));
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
