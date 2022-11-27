package io.github.ioni5.views.console;

import io.github.ioni5.controllers.StartController;
import io.github.ioni5.views.Message;
import utils.Console;
import utils.Intervale;
import utils.LimitedDialog;

public class StartView {

    private static final int MIN_HUMAN_PLAYERS = 0;

    private static final int MAX_HUMAN_PLAYERS = 2;

    public void interact(StartController startController) {
        new Console().write(Message.TITLE.getMessage());
        int numberOfHumanPlayers = new LimitedDialog(new Intervale(MIN_HUMAN_PLAYERS, MAX_HUMAN_PLAYERS))
        .read(Message.ENTER_NUM_OF_HUMAN_PLAYERS.getMessage()
            .replace("#MIN", "" + MIN_HUMAN_PLAYERS)
            .replace("#MAX", "" + MAX_HUMAN_PLAYERS));
        startController.setNumberOfHumanPlayers(numberOfHumanPlayers);
    }

}
