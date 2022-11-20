package io.github.ioni5;

import utils.Console;

public enum Error {
    INVALID_TO_PUT("\nError: No puedes poner en esta posición."),
    INVALID_TO_MOVE("\nError: No puedes mover esta ficha."),
    INVALID_COORDINATE("\nError: coordenada inválida."),
    NULL("");

    private String message;

    private Error(String message) {
        this.message = message;
    }

    public void show() {
        new Console().write(message);
    }
}
