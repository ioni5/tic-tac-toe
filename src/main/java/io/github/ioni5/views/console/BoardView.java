package io.github.ioni5.views.console;

import io.github.ioni5.controllers.PlayController;
import io.github.ioni5.models.Board;
import io.github.ioni5.models.Coordinate;
import utils.Console;

public class BoardView {

    private PlayController playController;

    public BoardView(PlayController playController) {
        this.playController = playController;
    }

    public void write() {
        Console console = new Console();
        console.write("\n");
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                new TokenView(playController.getToken(new Coordinate(i, j))).write();
            }
            console.write("\n");
        }
    }

}
