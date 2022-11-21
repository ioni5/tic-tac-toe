package io.github.ioni5;

import java.util.Random;

import utils.Console;
import utils.Intervale;

public class Coordinate extends utils.Coordinate {

    private static final Intervale LIMIT = new Intervale(0, Board.SIZE - 1);

    public Coordinate() {
        super();
    }

    public Coordinate(int row, int col) {
        super(row, col);
        assert LIMIT.includes(row) && LIMIT.includes(col);
    }

    public void obtain() {
        Console console = new Console();
        Error error;
        do {
            row = console.readInt(Message.ENTER_ROW.getMessage()) - 1;
            col = console.readInt(Message.ENTER_COLUMN.getMessage()) - 1;
            error = this.isValid();
            if (!error.isNull()) {
                error.show();
                console.write(Message.GET_COORDINATE.getMessage().replace("#INTERVALE", LIMIT.displaced().toString()));
            }
        } while (!error.isNull());
    }

    public Error isValid() {
        if (!LIMIT.includes(row) || !LIMIT.includes(col)) {
            return Error.INVALID_COORDINATE;
        }
        return Error.NULL;
    }

    public void random() {
        Random rnd = new Random();
        row = rnd.nextInt(Board.SIZE);
        col = rnd.nextInt(Board.SIZE);
    }
}
