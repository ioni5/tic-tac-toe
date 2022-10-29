package io.github.ioni5;

public class TicTacToe {

    static final int MAX_NUM_PLAYERS = 2;
    
    private Player[] players;

    private Turn turn;

    private Board board;

    public TicTacToe(int numPlayers) {
        players = new Player[MAX_NUM_PLAYERS];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new HumanPlayer(Token.values()[i]);
        }
        for (int i = numPlayers; i < MAX_NUM_PLAYERS; i++) {
            players[i] = new MachinePlayer(Token.values()[i]);
        }
        turn = new Turn(players);
        board = new Board();
    }

    public void play() {
        Console console = new Console();
        console.write("\nTic-Tac-Toe\n");
        Player player;
        do {
            board.show();
            player = turn.getPlayer();
            player.play(board);
            if (!this.gameover()) {
                turn.next();
            }
        } while (!this.gameover());
        board.show();
        new Console().write("\n¡Las '" + player.getToken() + "' ganan!\n");
    }

    private boolean gameover() {
        return board.hasWinner();
    }
}
