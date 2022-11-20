package io.github.ioni5;

public enum Token {
    O('o'), 
    X('x'),
    EMPTY('_');

    private char symbol;

    private Token(char symbol) {
        this.symbol = symbol;
    }
    
    public char getSymbol() {
        return symbol;
    }

}
