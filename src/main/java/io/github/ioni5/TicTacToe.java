package io.github.ioni5;

public class TicTacToe {
    
    private Player[] players;

    private Turn turn;

    private Board board;

    public TicTacToe() {
        players = new Player[] {
            new Player(Token.X),
            new Player(Token.O)
        };
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
