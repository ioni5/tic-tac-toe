package io.github.ioni5.models;

import java.util.Random;

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
