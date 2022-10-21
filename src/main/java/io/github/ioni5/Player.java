package io.github.ioni5;

public class Player {

    private Token token;

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

    private void put(Board board) {
        Console console = new Console();
        Coordinate coordinate;
        boolean error = false;
        do {
            coordinate = this.obtainCoordinate("¿En que posición?");
            error = !board.isValidToPut(coordinate);
            if (error) {
                console.write("\nError: No puedes poner en esta posición.");
            }
        } while (error);
        board.put(token, coordinate);         
    }

    private void move(Board board) {
        Console console = new Console();
        Coordinate from;
        Coordinate to = null;
        boolean error = false;
        do {
            from = this.obtainCoordinate("¿Desde que posición?");
            error = !board.isValidToRemove(token, from);
            if (error) {
                console.write("\nError: No puedes mover esta ficha.");
            } else {
                to = this.obtainCoordinate("¿Hacia que posición?");
                error = !board.isValidToPut(to);
                if (error) {
                    console.write("\nError: No puedes poner en esta posición.");
                }
            }
        } while (error);
        board.remove(token, from);
        board.put(token, to);
    }

    private Coordinate obtainCoordinate(String message) {
        Coordinate coordinate = new Coordinate();
        new Console().write("\n" + message);
        coordinate.obtain(Board.LIMIT);
        return coordinate;
    }

}
