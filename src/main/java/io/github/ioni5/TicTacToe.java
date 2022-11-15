package io.github.ioni5;

public class TicTacToe {

    private Turn turn;

    private Board board;

    public TicTacToe() {
        board = new Board();
        turn = new Turn(board);
    }

    public void play() {
        Console console = new Console();
        console.write("\nTic-Tac-Toe\n");
        do {
            board.show();
            turn.play();
            if (!board.hasWinner()) {
                turn.next();
            }
        } while (!board.hasWinner());
        board.show();
        turn.showWinner();
    }

}
