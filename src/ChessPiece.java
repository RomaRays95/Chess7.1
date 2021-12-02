abstract public class ChessPiece {
    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract public String getColor();
    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    abstract public String getSymbol();
    abstract public boolean canAttack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public static boolean way(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        int steps;
        if (Math.abs(toLine - line) == Math.abs(toColumn - column))
            steps = Math.abs(toLine - line) - 1;
        else steps = (Math.abs(toLine - line) + Math.abs(toColumn - column) -1);
        int l, c;
        l = Integer.compare(toLine, line);
        c = Integer.compare(toColumn, column);
        for (int i = 1; i <= steps; i++) {
            if (chessBoard.board[line + (l*i)][column + (c*i)] != null){
                return false;
            }
        }
        return true;
    }
}
