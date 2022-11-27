package io.github.ioni5;

import io.github.ioni5.controllers.Controller;
import io.github.ioni5.controllers.Logic;
import io.github.ioni5.views.View;

public abstract class TicTacToe {

    private Logic logic;

    private View view;

    public TicTacToe() {
        logic = new Logic();
        view = this.createView();
    }
    
    public void start() {
        do {
            view.interact(logic.getController());
        } while (!logic.isExit());
    }

    protected abstract View createView();
    
}
