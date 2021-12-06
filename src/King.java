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
        boolean result;
        result = canMoveWithoutIsUnderAttack(chessBoard, line, column, toLine, toColumn);
        if (isUnderAttack(chessBoard, toLine, toColumn)) result = false;
        return result;
    }

    private boolean canMoveWithoutIsUnderAttack (ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        boolean result = false;
        if ((toLine >= 0 && toLine <= 7) && (toColumn >= 0 && toColumn <= 7)){
            if (!(line == toLine && column == toColumn)){
                result = ((Math.abs(toLine - line) <= 1) && (Math.abs(toColumn - column) <= 1));
            }
        }
        if (chessBoard.board[toLine][toColumn] != null) {
            if (chessBoard.board[toLine][toColumn].getColor().equals(color)) result = false;
        }
        return result;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
        boolean result = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null) {
                    if (!board.board[i][j].getColor().equals(color)) {
                        if (board.board[i][j].canAttack(board, i, j, line, column)){
                            result = true;
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public boolean canAttack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return canMoveWithoutIsUnderAttack(chessBoard, line, column, toLine, toColumn);
    }
}
