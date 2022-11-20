package io.github.ioni5;

import utils.Console;
import utils.Intervale;

public class Turn {

    static final int MAX_NUM_PLAYERS = 2;

    private Player[] players;

    private int curr;

    public Turn(Board board) {
        players = new Player[MAX_NUM_PLAYERS];
        int numPlayers = this.getNumPlayers();
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new HumanPlayer(Token.values()[i], board);
        }
        for (int i = numPlayers; i < MAX_NUM_PLAYERS; i++) {
            players[i] = new MachinePlayer(Token.values()[i], board);
        }
    }

    private int getNumPlayers() {
        Console console = new Console();
        Intervale intervale = new Intervale(0, MAX_NUM_PLAYERS);
        int numPlayers;
        boolean error;
        do {
            numPlayers = console.readInt(Message.ENTER_NUM_PLAYERS.getMessage().replace("#INTERVALE", intervale.toString()));
            error = !intervale.includes(numPlayers);
        } while (error);
        return numPlayers;
    }

    private Player getPlayer() {
        return players[curr];
    }

    void next() {
        curr = (curr + 1) % players.length;
    }

    public void showWinner() {
        new Console().write(Message.WINNER.getMessage().replace("#PLAYER", this.getPlayer().getToken().name()));
    }

    public void play() {
        this.getPlayer().play();
    }

}
