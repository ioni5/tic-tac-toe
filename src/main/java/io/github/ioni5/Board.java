package io.github.ioni5;

public class Board {

    public static final int SIZE = 3;

    public static final Intervale LIMIT = new Intervale(1, SIZE);

    private Token[][] tokens;

    public Board() {
        tokens = new Token[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <SIZE; j++) {
                tokens[i][j] = Token.EMPTY;
            }
        }
    }

    public boolean isComplete(Token token) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <SIZE; j++) {
                if (tokens[i][j] == token) {
                   count++; 
                }
            }
        }
        return count == 3;
    }

    public boolean isValidToPut(Coordinate coordinate) {
        return isEmpty(coordinate);
    }

    private boolean isEmpty(Coordinate coordinate) {
        return this.getToken(coordinate) == Token.EMPTY;
    }

    public void put(Token token, Coordinate coordinate) {
        assert isValidToPut(coordinate);
        setToken(token, coordinate);
    }

    private void setToken(Token token, Coordinate coordinate) {
        tokens[coordinate.getRow() - 1][coordinate.getCol() - 1] = token;
    }

    public void remove(Token token, Coordinate coordinate) {
        assert isValidToRemove(token, coordinate);
        this.setToken(Token.EMPTY, coordinate);
    }

    public boolean isValidToRemove(Token token, Coordinate coordinate) {
        return this.getToken(coordinate) == token;
    }

    private Token getToken(Coordinate coordinate) {
        return tokens[coordinate.getRow() - 1][coordinate.getCol() - 1];
    }

    public boolean hasWinner() {
        return this.isWinner(Token.O) || this.isWinner(Token.X);
    }

    private boolean isWinner(Token token) {
        int[] rows = new int[SIZE];
        int[] cols = new int[SIZE];
        int diagonal = 0;
        int inverse = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <SIZE; j++) {
                if (tokens[i][j] == token) {
                    rows[i]++;
                    cols[j]++;
                    if (i == j) {
                        diagonal++;
                    } 
                    if (i + j == SIZE - 1) {
                        inverse++;
                    }
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            if (rows[i] == SIZE || cols[i] == SIZE) {
                return true;
            }
        }
        return diagonal == SIZE || inverse == SIZE;
    }

    public void show() {
        Console console = new Console();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                console.write(tokens[i][j].toString());            
            }
            console.write("\n");
        }
    }

}
