package src;

import java.util.ArrayList;

public class HorsePiece extends ChessPiece {
    public HorsePiece(Position pos) {
        super(pos);
    }

    @Override
    public ArrayList<Position> validMoves()
    {
        ArrayList<Position> valid = new ArrayList<>();

        Position target1 = getPosition().add(3, -1);
        if(target1 != null) valid.add(target1);

        Position target2 = getPosition().add(-1, -3);
        if(target2 != null) valid.add(target2);

        Position target3 = getPosition().add(-3, 1);
        if(target3 != null) valid.add(target3);

        Position target4 = getPosition().add(3, 1);
        if(target4 != null) valid.add(target4);

        return valid;
    }
}
