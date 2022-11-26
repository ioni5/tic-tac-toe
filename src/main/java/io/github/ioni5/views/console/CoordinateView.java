package io.github.ioni5.views.console;

import io.github.ioni5.models.Coordinate;
import io.github.ioni5.models.Error;
import io.github.ioni5.views.Message;
import utils.Console;

public class CoordinateView {

    private static final CharSequence MIN = "1";

    private static final CharSequence MAX = "3";

    public Coordinate read(String message) {
        Console console = new Console();
        console.write(message);
        Coordinate coordinate;
        int row;
        int column;
        Error error;
        do {
            row = console.readInt(Message.ENTER_ROW.getMessage()) - 1;
            column = console.readInt(Message.ENTER_COLUMN.getMessage()) - 1;
            coordinate = new Coordinate(row, column);
            error = coordinate.isValid();
            if (!error.isNull()) {
                new ErrorView(error).write();
                console.write(Message.GET_COORDINATE.getMessage()
                .replace("#MIN", MIN)
                .replace("#MAX", MAX));
            }
        } while(!error.isNull());
        return coordinate;
    }

}
