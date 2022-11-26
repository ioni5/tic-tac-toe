package io.github.ioni5.views.console;

import io.github.ioni5.models.Board;
import io.github.ioni5.models.Coordinate;
import io.github.ioni5.models.Game;
import utils.Console;

public class BoardView {

    private Game game;

    public BoardView(Game game) {
        this.game = game;
    }

    public void write() {
        Console console = new Console();
        console.write("\n");
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                new TokenView(game.getToken(new Coordinate(i, j))).write();
            }
            console.write("\n");
        }
    }

}
