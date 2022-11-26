package io.github.ioni5.controllers;

import io.github.ioni5.models.Coordinate;
import io.github.ioni5.models.Game;
import io.github.ioni5.models.Token;

public class Controller {
    
    protected Game game;

    public Controller(Game game) {
        this.game = game;
    }

    public Token getToken(Coordinate coordinate) {
        return game.getToken(coordinate);
    }
}
