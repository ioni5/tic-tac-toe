package io.github.ioni5;

public class MachinePlayer extends Player {

    public MachinePlayer(Token token, Board board) {
        super(token, board);
    }

    @Override
    protected Coordinate obtainCoordinate(String message) {
        Coordinate coordinate = new Coordinate();
        coordinate.random();
        return coordinate;
    }

}
