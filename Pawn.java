package util;
import game.*;

public class Pawn extends Piece{
    public Pawn(boolean white) {
        super(white);
    }
    @Override
    public boolean isLegal(Move move, Game game) {
        if (!super.isLegal(move, game)) {
            return false;
        }
        //rules for pawn only!
        int rowDiff = move.getRow1() - move.getRow0();
        int colDiff = move.getCol1() - move.getCol0();

        if (rowDiff > 0 && white || rowDiff < 0 && !white)
            return false;//pawn doesn't move backward!

        Piece capturedPiece = game.getPiece(move.getRow1(), move.getCol1());

        if (capturedPiece == null){
            //moving and not capturing a piece
            if(colDiff != 0 || (Math.abs(rowDiff) != 1 && Math.abs(rowDiff) != 2)){
                return false;
            }
            if(rowDiff == 2 && move.getRow0() != 1) // moving 2 squares forward is only allowed at initial position
                return false;
            if(rowDiff == -2 && move.getRow0() != 6)// moving 2 squares forward is only allowed at initial position
                return false;

        } else {//capturing
            if(Math.abs(colDiff) != 1 || Math.abs(rowDiff) != 1){
                //capturing diagonally
                return false;
            }
            if (capturedPiece.white == white) {
                //same color can't be captured
                return false;
            }
        }

        return true;


    }
    @Override
    public String toString() {
        return white?"\u2659":"\u265F";
    }
}
