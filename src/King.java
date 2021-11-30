public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((toLine >= 0 && toLine <= 7) && (toColumn >= 0 && toColumn <= 7)){
            if (!(line == toLine && column == toColumn)){
                return ((Math.abs(toLine - line) <= 1) && (Math.abs(toColumn - column) <= 1));
            }
        }
        return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
        for (int i = 7; i > -1; i--) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null) {
                    if (!board.board[i][j].getColor().equals(color)) {
                        return (board.board[i][j].canAttack(board, i, j, line, column));
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public boolean canAttack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return canMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }
}
