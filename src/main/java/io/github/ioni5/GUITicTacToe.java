package io.github.ioni5;

import io.github.ioni5.views.gui.View;

public class GUITicTacToe extends TicTacToe {

    @Override
    protected View createView() {
        return new View();
    }

    public static void main(String[] args) {
        new GUITicTacToe().start();
    }
}
