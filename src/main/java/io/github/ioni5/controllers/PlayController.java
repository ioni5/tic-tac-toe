package io.github.ioni5.controllers;

import io.github.ioni5.models.Coordinate;
import io.github.ioni5.models.Error;
import io.github.ioni5.models.Game;
import io.github.ioni5.models.Token;

public class PlayController extends Controller {

    public PlayController(Game game) {
        super(game);
    }

    public Token getToken() {
        return game.getToken();
    }

    public boolean isComplete() {
        return game.isComplete();
    }

    public boolean hasWinner() {
        return game.hasWinner();
    }

    public void next() {
        game.next();
    }

    public boolean isHumanPlayer() {
        return game.isHumanPlayer();
    }

    public Error isValidToPut(Coordinate coordinate) {
        return game.isValidToPut(coordinate);
    }

    public void put(Coordinate coordinate) {
        game.put(coordinate);
    }

    public Error isValidToRemove(Coordinate origin) {
        return game.isValidToRemove(origin);
    }

    public void move(Coordinate origin, Coordinate target) {
        game.move(origin, target);
    }
    
}
