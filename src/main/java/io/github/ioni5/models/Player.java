package io.github.ioni5.models;

public class Player {

    protected Token token;

    protected Board board;

    public Player(Token token, Board board) {
        this.token = token;
        this.board = board;
    }

    public Token getToken() {
        return token;
    }

    public void put(Coordinate coordinate) {
        board.put(token, coordinate);         
    }

    public void move(Coordinate origin, Coordinate target) {
        board.remove(token, origin);
        board.put(token, target);
    }

    public boolean isComplete() {
        return board.isComplete(token);
    }

}
