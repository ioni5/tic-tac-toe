package io.github.ioni5.views.console;

import io.github.ioni5.controllers.PlayController;
import io.github.ioni5.models.Coordinate;
import io.github.ioni5.models.Error;
import io.github.ioni5.views.Message;
import utils.Console;

public class PlayView {

    public void interact(PlayController playController) {
        Console console = new Console();
        BoardView boardView = new BoardView(playController);
        boardView.write();
        char player;
        do {
            player = new TokenView(playController.getToken()).getSymbol();
            if (playController.isComplete()) {
                console.write(Message.MOVE.getMessage().replace("#PLAYER", "" + player));
                this.move(playController);
            } else {
                console.write(Message.PUT.getMessage().replace("#PLAYER", "" + player));
                this.put(playController);
            }
            boardView.write();
            if (!playController.hasWinner()) {
                playController.next();
            }
        } while (!playController.hasWinner());
        new Console().write(Message.WINNER.getMessage()
            .replace("#PLAYER", "" + player));
    }

    private void put(PlayController playController) {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.obtainCoordinate(Message.GET_COORDINATE_TO_PUT.getMessage(), playController);
            error = playController.isValidToPut(coordinate);
            if (!error.isNull() && playController.isHumanPlayer()) {
                new ErrorView(error).write();
            }
        } while (!error.isNull());
        playController.put(coordinate);
    }

    private void move(PlayController playController) {
        Coordinate origin = null;
        Coordinate target = null;
        Error error;
        do {
            origin = this.obtainCoordinate(Message.GET_COORDINATE_TO_MOVE_ORIGIN.getMessage(), playController);
            error = playController.isValidToRemove(origin);
            if (error.isNull()) {
                target = this.obtainCoordinate(Message.GET_COORDINATE_TO_MOVE_TARGET.getMessage(), playController);
                error = playController.isValidToPut(target);
            }
            if (!error.isNull() && playController.isHumanPlayer()) {
                new ErrorView(error).write();
            }
        } while (!error.isNull());
        playController.move(origin, target);
    }

    private Coordinate obtainCoordinate(String message, PlayController playController) {
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
