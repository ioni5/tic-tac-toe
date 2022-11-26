package io.github.ioni5.views.console;

import io.github.ioni5.models.Token;
import utils.Console;

public class TokenView {

    private static final char[] SYMBOLS = {'o', 'x', '_'};

    private Token token;

    public TokenView(Token token) {
        this.token = token;
    }

    public void write() {
        new Console().write(SYMBOLS[token.ordinal()]);
    }

    public char getSymbol() {
        return SYMBOLS[token.ordinal()];
    }

}
