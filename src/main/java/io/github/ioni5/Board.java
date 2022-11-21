package io.github.ioni5;

import utils.Console;
import utils.Coordinate;

public class Board {

    public static final int SIZE = 3;

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
        assert token != null;
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

    public Error isValidToPut(Coordinate coordinate) {
        assert coordinate != null;
        if (!isEmpty(coordinate)) {
            return Error.INVALID_TO_PUT;
        }
        return Error.NULL;
    }

    private boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null;
        return this.getToken(coordinate) == Token.EMPTY;
    }

    public Error isValidToRemove(Token token, Coordinate coordinate) {
        assert token != null && coordinate != null;
        if (this.getToken(coordinate) != token) {
            return Error.INVALID_TO_MOVE;
        }
        return Error.NULL;
    }

    public void put(Token token, Coordinate coordinate) {
        assert isValidToPut(coordinate).isNull();
        setToken(token, coordinate);
    }

    private void setToken(Token token, Coordinate coordinate) {
        assert token != null && coordinate != null;
        tokens[coordinate.getRow()][coordinate.getCol()] = token;
    }

    public void remove(Token token, Coordinate coordinate) {
        assert isValidToRemove(token, coordinate).isNull();
        this.setToken(Token.EMPTY, coordinate);
    }

    private Token getToken(Coordinate coordinate) {
        assert coordinate != null;
        return tokens[coordinate.getRow()][coordinate.getCol()];
    }

    public boolean hasWinner() {
        return this.isWinner(Token.O) || this.isWinner(Token.X);
    }

    private boolean isWinner(Token token) {
        assert token != null;
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
        console.write("\n");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                console.write(tokens[i][j].getSymbol());            
            }
            console.write("\n");
        }
    }

}
