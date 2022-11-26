package io.github.ioni5;

import io.github.ioni5.models.Game;
import io.github.ioni5.views.View;

public abstract class TicTacToe {

    protected Game game;

    protected View view;

    public TicTacToe() {
        game = new Game();
        view = this.createView();
    }
    
    public void start() {
        view.interact();
    }

    protected abstract View createView();
    
}
