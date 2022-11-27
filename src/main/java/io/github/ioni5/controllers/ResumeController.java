package io.github.ioni5.controllers;

import io.github.ioni5.models.Game;

public class ResumeController extends Controller {

    public ResumeController(Game game, State state) {
        super(game, state);
    }

    public void reset() {
        game.reset();
        state.reset();
    }

    public void next() {
        state.next();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
    
}
