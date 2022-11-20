package io.github.ioni5;

public class HumanPlayer extends Player {

    public HumanPlayer(Token token, Board board) {
        super(token, board);
    }

    @Override
    protected Error isValidToPut(Coordinate coordinate) {
        Error error = super.isValidToPut(coordinate);
        error.show();
        return error;
    }

    @Override
    protected Error isValidToRemove(Coordinate coordinate) {
        Error error = super.isValidToRemove(coordinate);
        error.show();
        return error;
    }

    @Override
    protected Coordinate obtainCoordinate(String message) {
        Coordinate coordinate = new Coordinate();
        new Console().write("\n" + message);
        coordinate.obtain();
        return coordinate;
    }
}
