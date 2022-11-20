package io.github.ioni5;

import utils.Console;

public abstract class Player {

    protected Token token;

    protected Board board;

    public Player(Token token, Board board) {
        this.token = token;
        this.board = board;
    }

    public Token getToken() {
        return token;
    }

    public void play() {
        Console console = new Console();
        if (board.isComplete(token)) {
            console.write(Message.MOVE.getMessage().replace("#PLAYER", "" + token.getSymbol()));
            this.move();
        } else {
            console.write(Message.PUT.getMessage().replace("#PLAYER", "" + token.getSymbol()));
            this.put();
        }
    }

    public void put() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.obtainCoordinate(Message.GET_COORDINATE_TO_PUT.getMessage());
            error = board.isValidToPut(coordinate);
        } while (error != Error.NULL);
        board.put(token, coordinate);         
    }

    public void move() {
        Coordinate from;
        Coordinate to = null;
        Error error;
        do {
            from = this.obtainCoordinate(Message.GET_COORDINATE_TO_MOVE_ORIGIN.getMessage());
            error = this.isValidToRemove(from);
            if (error == Error.NULL) {
                to = this.obtainCoordinate(Message.GET_COORDINATE_TO_MOVE_TARGET.getMessage());
                error = board.isValidToPut(to);
            }
        } while (error != Error.NULL);
        board.remove(token, from);
        board.put(token, to);
    }

    protected Error isValidToRemove(Coordinate coordinate) {
        return board.isValidToRemove(token, coordinate);
    }

    protected Error isValidToPut(Coordinate coordinate) {
        return board.isValidToPut(coordinate);
    }

    protected abstract Coordinate obtainCoordinate(String message);

}
