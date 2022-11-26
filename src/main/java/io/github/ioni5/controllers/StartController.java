package io.github.ioni5.controllers;

import io.github.ioni5.models.Game;

public class StartController extends Controller {

    public StartController(Game game) {
        super(game);
    }

    public void setNumberOfHumanPlayers(int numberOfHumanPlayers) {
        game.setNumberOfHumanPlayers(numberOfHumanPlayers);
    }


    
}
