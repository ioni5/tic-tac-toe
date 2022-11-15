package io.github.ioni5;

enum Error {
    PUT("\nError: No puedes poner en esta posición."),
    MOVE("\nError: No puedes mover esta ficha."),
    NULL("");

    private String message;

    private Error(String message) {
        this.message = message;
    }

    public void show() {
        new Console().write(message);
    }
}
