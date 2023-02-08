package src;

import java.util.ArrayList;
import java.util.List;

public class BishopPiece extends ChessPiece {
    public BishopPiece(Position pos) {
        super(pos);
    }

    @Override
    public ArrayList<Position> validMoves() {
        ArrayList<Position> valid = new ArrayList<>();

        int colDiff = 1;    //How much to space away checks on a single line
        for(int i = getPosition().getRow() + 1; i < 8; i++) {    //We use 8 as that is the board size
            addDiagonalPositions(i, colDiff, valid);
            
            colDiff += 2;
        }

        colDiff = 1;
        for(int i = getPosition().getRow() + 1; i > 0; i--) {
            addDiagonalPositions(i, colDiff, valid);

            colDiff += 2;
        }

        return valid;
    }

    private void addDiagonalPositions(int row, int diff, List<Position> positions) {
        Position rightTarget = getPosition().add(row, diff);   //Add towards right
        if(rightTarget != null) positions.add(rightTarget);

        Position leftTarget = getPosition().add(row, -diff);   //Subtract (go towards left)
        if(leftTarget != null) positions.add(leftTarget);
    }
}
