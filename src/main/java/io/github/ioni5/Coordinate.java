package io.github.ioni5;

public class Coordinate {

    private int row;

    private int col;

    public Coordinate() {}

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void obtain() {
        Console console = new Console();
        row = console.readInt("\nIngresa fila: ");
        col = console.readInt("Ingresa columna: ");
    }

    public void obtain(Intervale limit) {
        Console console = new Console();
        boolean error = false;
        do {
            this.obtain();
            error = !limit.includes(row) || !limit.includes(col);
            if (error) {
                console.write("\nError: coordenada invalida.\nIngresa numero entre " + limit.toString() + ".");
            }
        } while (error);
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
