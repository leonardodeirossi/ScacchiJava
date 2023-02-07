public class Position {
    private int row;
    private char col;

    public Position(int row, char col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public char getCol() {
        return this.col;
    }

    public void setPosition(int row, char col) throws Exception {
        if (isValid(row, col)) {
            setPosition(new Position(row, col));
        } else {
            throw new Exception("invalid position");
        }
    }

    public void setPosition(Position pos) throws Exception {
        this.row = pos.row;
        this.col = pos.col;
    }

    public boolean isValid() {
        return true; // To be implemented
    }

    public boolean isValid(int row, char col) {
        return true; // To be implemented
    }

    public boolean equals(Position pos) {
        return this.row == pos.row && this.col == pos.col;
    }
}