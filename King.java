package util;
import game.*;
public class King extends Piece{
    public King(boolean white) {
        super(white);
    }
    @Override
    public boolean isLegal(Move move, Game game) {
        if(!super.isLegal(move, game))
            return false;
        // rules for king only!
        int rowDiff = Math.abs(move.getRow1() - move.getRow0());
        int colDiff = Math.abs(move.getCol1() - move.getCol0());
        if (rowDiff > 1 || colDiff > 1) { // king can only move one square in any direction
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return white ? "\u2654" : "\u265A";
    }
}

