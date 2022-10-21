package io.github.ioni5;

public enum Token {
    O('o'), 
    X('x'),
    EMPTY('_');

    private char value;

    private Token(char value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return Character.toString(value);
    }

}
