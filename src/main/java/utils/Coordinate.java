package utils;

public class Coordinate {

    protected int row;

    protected int col;

    public Coordinate() {}

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object object) {
        Coordinate coordinate = (Coordinate) object;
        return row == coordinate.row && col == coordinate.col;
    }
}
