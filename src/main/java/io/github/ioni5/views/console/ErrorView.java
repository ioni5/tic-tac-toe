package io.github.ioni5.views.console;

import io.github.ioni5.models.Error;
import utils.Console;

public class ErrorView {

    private static final String[] MESSAGES = {
        "\nError: No puedes poner en esta posición.",
        "\nError: No puedes mover esta ficha.",
        "\nError: Coordenada inválida."
    };

    private Error error;

    public ErrorView(Error error) {
        this.error = error;
    }

    public void write() {
        new Console().write(MESSAGES[error.ordinal()]);
    }

}
