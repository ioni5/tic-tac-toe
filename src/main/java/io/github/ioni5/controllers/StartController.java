package io.github.ioni5.controllers;

import io.github.ioni5.models.Game;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void setNumberOfHumanPlayers(int numberOfHumanPlayers) {
        game.setNumberOfHumanPlayers(numberOfHumanPlayers);
        state.next();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }


    
}
