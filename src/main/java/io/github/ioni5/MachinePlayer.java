package io.github.ioni5;

import java.util.Random;

public class MachinePlayer extends Player {

    public MachinePlayer(Token token, Board board) {
        super(token, board);
    }

    @Override
    protected Coordinate obtainCoordinate(String message) {
        Random rnd = new Random();
        return new Coordinate(rnd.nextInt(Board.SIZE), 
            rnd.nextInt(Board.SIZE));
    }

}
