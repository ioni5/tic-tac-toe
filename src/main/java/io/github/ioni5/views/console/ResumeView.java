package io.github.ioni5.views.console;

import io.github.ioni5.models.Game;
import io.github.ioni5.views.Message;
import utils.YesOrNotDialog;

public class ResumeView {

    private Game game;

    public ResumeView(Game game) {
        this.game = game;
    }

    public boolean interact() {
        boolean isResumed = new YesOrNotDialog().read(Message.RESUME.getMessage());
        if (isResumed) {
            game.reset();
        }
        return isResumed;
    }

}
