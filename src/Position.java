package src;

public class Position {
    private int row;
    private int col;

    public Position(int row, char col) {
        if((col >= 97 && col <= 105)
            || (col >= 65 && col <= 73)) {

            //If col is above 97 it is lowercase, subtract 32 to get uppercase
            if(col >= 97) col -= 32;
            this.col = col - 64;    //Subtract 64 to get actual 1-8 number (uppercase A is 65)

            if (!isValid(row, col)) {
                throw new IllegalArgumentException("Invalid position \"" + row + col + "\"");
            }

            this.row = row;
        } else {
            throw new IllegalArgumentException("Column must be between 'A' and 'H' or 'a' and 'h'");
        }
    }

    //Internal constructor using two ints
    private Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }
    public int getCol() { return this.col; }

    public char getColChar() {
        return (char) (this.col + 64);
    }

    public void setPosition(int row, char col) throws Exception {
        if (isValid(row, col)) {
            this.row = row;
            this.col = col;
        } else {
            throw new Exception("invalid position");
        }
    }

    public void setPosition(Position pos) throws Exception {
        this.row = pos.row;
        this.col = pos.col;
    }

    public boolean isValid() {
        return isValid(row, getColChar());
    }

    public boolean isValid(int row, char col) {
        return (row > 0 && row <= 8)    //Row must be between 1 and 8 (inclusive)
                && (col > 0 && col <= 8); //Column must be between 1 and 8 (inclusive)
    }

    public Position add(int rows, int cols)
    {
        Position newPos;
        try
        {
            newPos = new Position(row + rows, col + cols);
        } catch (Exception e) { newPos = null; }

        return newPos;
    }

    public boolean equals(Position pos) { return this.row == pos.row && this.col == pos.col; }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Position && equals((Position) obj);
    }

    @Override
    public String toString() {
        return "" + row + col;
    }
}