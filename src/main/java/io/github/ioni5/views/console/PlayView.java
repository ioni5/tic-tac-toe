package io.github.ioni5.views.console;

import io.github.ioni5.models.Coordinate;
import io.github.ioni5.models.Error;
import io.github.ioni5.models.Game;
import io.github.ioni5.views.Message;
import utils.Console;

public class PlayView {

    private Game game;

    private BoardView boardView;

    public PlayView(Game game) {
        this.game = game;
        boardView = new BoardView(game);
    }

    public void interact() {
        Console console = new Console();
        char player;
        boardView.write();
        do {
            player = new TokenView(game.getToken()).getSymbol();
            if (game.isComplete()) {
                console.write(Message.MOVE.getMessage().replace("#PLAYER", "" + player));
                this.move();
            } else {
                console.write(Message.PUT.getMessage().replace("#PLAYER", "" + player));
                this.put();
            }
            boardView.write();
            if (!game.hasWinner()) {
                game.next();
            }
        } while (!game.hasWinner());
        new Console().write(Message.WINNER.getMessage()
            .replace("#PLAYER", "" + player));
    }

    private void put() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.obtainCoordinate(Message.GET_COORDINATE_TO_PUT.getMessage());
            error = game.isValidToPut(coordinate);
            if (!error.isNull() && game.isHumanPlayer()) {
                new ErrorView(error).write();
            }
        } while (!error.isNull());
        game.put(coordinate);
    }

    private void move() {
        Coordinate origin = null;
        Coordinate target = null;
        Error error;
        do {
            origin = this.obtainCoordinate(Message.GET_COORDINATE_TO_MOVE_ORIGIN.getMessage());
            error = game.isValidToRemove(origin);
            if (error.isNull()) {
                target = this.obtainCoordinate(Message.GET_COORDINATE_TO_MOVE_TARGET.getMessage());
                error = game.isValidToPut(target);
            }
            if (!error.isNull() && game.isHumanPlayer()) {
                new ErrorView(error).write();
            }
        } while (!error.isNull());
        game.move(origin, target);
    }

    private Coordinate obtainCoordinate(String message) {
        Coordinate coordinate;
        if (game.isHumanPlayer()) {
            coordinate = new CoordinateView().read(message);
        } else {
            coordinate = new Coordinate();
            coordinate.random();
        }
        return coordinate;
    }

}
