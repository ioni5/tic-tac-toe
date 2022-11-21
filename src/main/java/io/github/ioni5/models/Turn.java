package io.github.ioni5.models;

public class Turn {

    static final int MAX_NUM_PLAYERS = 2;

    private Board board;

    private Player[] players;

    private int curr;

    private int numberOfHumanPlayers;

    public Turn(Board board) {
        this.board = board;
        players = new Player[MAX_NUM_PLAYERS];
        for (int i = 0; i < MAX_NUM_PLAYERS; i++) {
            players[i] = new Player(Token.values()[i], board);
        }
    }

    private Player getPlayer() {
        return players[curr];
    }

    void next() {
        curr = (curr + 1) % players.length;
    }

    public Token getToken() {
        return this.getPlayer().getToken();
    }

    public boolean isHumanPlayer() {
        return numberOfHumanPlayers == 2 || numberOfHumanPlayers == 1 && curr == 0;
    }

    public boolean isComplete() {
        return this.getPlayer().isComplete();
    }

    public Error isValidToPut(Coordinate coordinate) {
        return board.isValidToPut(coordinate);
    }

    public Error isValidToRemove(Coordinate coordinate) {
        return board.isValidToRemove(this.getToken(), coordinate);
    }

    public void put(Coordinate coordinate) {
        this.getPlayer().put(coordinate);
    }

    public void move(Coordinate origin, Coordinate target) {
        this.getPlayer().move(origin, target);
    }

    public void setNumberOfHumanPlayers(int numberOfHumanPlayers) {
        this.numberOfHumanPlayers = numberOfHumanPlayers;
    }

    public void reset() {
        curr = 0;
    }

}
