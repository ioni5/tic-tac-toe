package io.github.ioni5;

public class Coordinate {

    private static final Intervale LIMIT = new Intervale(1, Board.SIZE);

    private int row;

    private int col;

    public Coordinate() {}

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void obtain() {
        Console console = new Console();
        Error error;
        do {
            row = console.readInt("\nIngresa fila: ");
            col = console.readInt("Ingresa columna: ");
            error = this.isValid();
            if (error != Error.NULL) {
                error.show();
                console.write(Message.GET_COORDINATE.getMessage().replace("#INTERVALE", LIMIT.toString()));
            }
        } while (error != Error.NULL);
    }

    public Error isValid() {
        if (!LIMIT.includes(row) || !LIMIT.includes(col)) {
            return Error.INVALID_COORDINATE;
        }
        return Error.NULL;
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
