package io.github.ioni5;

import utils.Console;

public enum Error {
    INVALID_TO_PUT("\nError: No puedes poner en esta posición."),
    INVALID_TO_MOVE("\nError: No puedes mover esta ficha."),
    INVALID_COORDINATE("\nError: coordenada inválida."),
    NULL(null);

    private String message;

    private Error(String message) {
        this.message = message;
    }

    public boolean isNull() {
        return this.equals(Error.NULL);
    }

    public void show() {
        assert !this.isNull();
        new Console().write(message);
    }
}
