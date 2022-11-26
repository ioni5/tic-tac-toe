package io.github.ioni5;

import io.github.ioni5.views.console.View;

public class CLITicTacToe extends TicTacToe {

    @Override
    protected View createView() {
        return new View(game);
    }
    
    public static void main( String[] args ) {
        new CLITicTacToe().start();
    }

}
