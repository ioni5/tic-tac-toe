package io.github.ioni5;

public abstract class Player {

    protected Token token;

    public Player(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void play(Board board) {
        Console console = new Console();
        if (board.isComplete(token)) {
            console.write("\nLas '" + token + "' mueven.");
            this.move(board);
        } else {
            console.write("\nLas '" + token + "' ponen.");
            this.put(board);
        }
    }

    protected abstract void put(Board board);

    protected abstract void move(Board board);

}
