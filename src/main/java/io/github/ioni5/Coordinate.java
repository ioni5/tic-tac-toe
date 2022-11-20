package io.github.ioni5;

import utils.Intervale;

public class Coordinate extends utils.Coordinate {

    private static final Intervale LIMIT = new Intervale(1, Board.SIZE);

    public Coordinate() {
        super();
    }

    public Coordinate(int row, int col) {
        super(row, col);
    }

    public void obtain() {
        Console console = new Console();
        Error error;
        do {
            row = console.readInt(Message.ENTER_ROW.getMessage());
            col = console.readInt(Message.ENTER_COLUMN.getMessage());
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
}
