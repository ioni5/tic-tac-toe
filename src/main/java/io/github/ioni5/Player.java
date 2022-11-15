package io.github.ioni5;

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
            console.write("\nLas '" + token + "' mueven.");
            this.move();
        } else {
            console.write("\nLas '" + token + "' ponen.");
            this.put();
        }
    }

    public void put() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.obtainCoordinate("¿En que posición?");
            error = board.isValidToPut(coordinate);
        } while (error != Error.NULL);
        board.put(token, coordinate);         
    }

    public void move() {
        Coordinate from;
        Coordinate to = null;
        Error error;
        do {
            from = this.obtainCoordinate("¿Desde que posición?");
            error = this.isValidToRemove(from);
            if (error == Error.NULL) {
                to = this.obtainCoordinate("¿Hacia que posición?");
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
