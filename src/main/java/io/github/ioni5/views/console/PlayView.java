package io.github.ioni5.views.console;

import io.github.ioni5.controllers.PlayController;
import io.github.ioni5.models.Coordinate;
import io.github.ioni5.models.Error;
import io.github.ioni5.views.Message;
import utils.Console;

public class PlayView {

    private PlayController playController;

    private BoardView boardView;

    public PlayView(PlayController playController) {
        this.playController = playController;
        boardView = new BoardView(playController);
    }

    public void interact() {
        Console console = new Console();
        char player;
        boardView.write();
        do {
            player = new TokenView(playController.getToken()).getSymbol();
            if (playController.isComplete()) {
                console.write(Message.MOVE.getMessage().replace("#PLAYER", "" + player));
                this.move();
            } else {
                console.write(Message.PUT.getMessage().replace("#PLAYER", "" + player));
                this.put();
            }
            boardView.write();
            if (!playController.hasWinner()) {
                playController.next();
            }
        } while (!playController.hasWinner());
        new Console().write(Message.WINNER.getMessage()
            .replace("#PLAYER", "" + player));
    }

    private void put() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.obtainCoordinate(Message.GET_COORDINATE_TO_PUT.getMessage());
            error = playController.isValidToPut(coordinate);
            if (!error.isNull() && playController.isHumanPlayer()) {
                new ErrorView(error).write();
            }
        } while (!error.isNull());
        playController.put(coordinate);
    }

    private void move() {
        Coordinate origin = null;
        Coordinate target = null;
        Error error;
        do {
            origin = this.obtainCoordinate(Message.GET_COORDINATE_TO_MOVE_ORIGIN.getMessage());
            error = playController.isValidToRemove(origin);
            if (error.isNull()) {
                target = this.obtainCoordinate(Message.GET_COORDINATE_TO_MOVE_TARGET.getMessage());
                error = playController.isValidToPut(target);
            }
            if (!error.isNull() && playController.isHumanPlayer()) {
                new ErrorView(error).write();
            }
        } while (!error.isNull());
        playController.move(origin, target);
    }

    private Coordinate obtainCoordinate(String message) {
        Coordinate coordinate;
        if (playController.isHumanPlayer()) {
            coordinate = new CoordinateView().read(message);
        } else {
            coordinate = new Coordinate();
            coordinate.random();
        }
        return coordinate;
    }

}
