package io.github.ioni5.models;

public class Game {

    private Turn turn;

    private Board board;

    public Game() {
        board = new Board();
        turn = new Turn(board);
    }

    public Token getToken(Coordinate coordinate) {
        return board.getToken(coordinate);
    }

    public boolean isComplete() {
        return turn.isComplete();
    }

    public boolean hasWinner() {
        return board.hasWinner();
    }

    public void next() {
        turn.next();
    }

    public boolean isHumanPlayer() {
        return turn.isHumanPlayer();
    }

    public Error isValidToPut(Coordinate coordinate) {
        return turn.isValidToPut(coordinate);
    }

    public void put(Coordinate coordinate) {
        turn.put(coordinate);
    }

    public Error isValidToRemove(Coordinate coordinate) {
        return turn.isValidToRemove(coordinate);
    }

    public void move(Coordinate origin, Coordinate target) {
        turn.move(origin, target);
    }

    public Token getToken() {
        return turn.getToken();
    }

    public void reset() {
        board.reset();
        turn.reset();
    }

    public void setNumberOfHumanPlayers(int numberOfHumanPlayers) {
        turn.setNumberOfHumanPlayers(numberOfHumanPlayers);
    }

}
