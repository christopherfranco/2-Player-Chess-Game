package util;
import game.*;

public class Knight extends Piece{
    public Knight(boolean white) {
        super(white);
    }
    @Override
    public boolean isLegal(Move move, Game game) {
        if(!super.isLegal(move, game))
            return false;
        //rules for knight only!
        int rowDiff = Math.abs(move.getRow1() - move.getRow0());
        int colDiff = Math.abs(move.getCol1() - move.getCol0());

        return (rowDiff == 1 && colDiff == 2) || (rowDiff == 2 && colDiff == 1);
    }

    @Override
    public String toString() {
        return white?"\u2658":"\u265E";
    }
}
