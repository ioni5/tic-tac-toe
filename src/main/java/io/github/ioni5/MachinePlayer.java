package io.github.ioni5;

import java.util.Random;

public class MachinePlayer extends Player {

    public MachinePlayer(Token token) {
        super(token);
    }

    @Override
    protected void put(Board board) {
        Coordinate coordinate;
        boolean error = false;
        do {
            coordinate = this.obtainCoordinate();
            error = !board.isValidToPut(coordinate);
        } while (error);
        new Console().write("\n");
        board.put(token, coordinate);
    }

    @Override
    protected void move(Board board) {
        Coordinate from;
        Coordinate to;
        boolean error = false;
        do {
            from = this.obtainCoordinate();
            error = !board.isValidToRemove(token, from);
        } while (error);
        do {
            to = this.obtainCoordinate();
            error = !board.isValidToPut(to);
        } while (error);
        new Console().write("\n");
        board.remove(token, from);
        board.put(token, to);
    }

    private Coordinate obtainCoordinate() {
        Random rnd = new Random();
        return new Coordinate(rnd.nextInt(Board.SIZE) + 1, 
            rnd.nextInt(Board.SIZE) + 1);
    }

}
