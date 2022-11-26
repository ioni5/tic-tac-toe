package io.github.ioni5.controllers;

import io.github.ioni5.models.Game;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public void reset() {
        game.reset();
    }
    
}
