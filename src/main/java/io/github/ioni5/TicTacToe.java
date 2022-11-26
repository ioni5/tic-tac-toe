package io.github.ioni5;

import io.github.ioni5.controllers.PlayController;
import io.github.ioni5.controllers.ResumeController;
import io.github.ioni5.controllers.StartController;
import io.github.ioni5.models.Game;
import io.github.ioni5.views.View;

public abstract class TicTacToe {

    private Game game;

    private StartController startController;

    private PlayController playController;

    private ResumeController resumeController;

    private View view;

    public TicTacToe() {
        game = new Game();
        startController = new StartController(game);
        playController = new PlayController(game);
        resumeController = new ResumeController(game);
        view = this.createView(startController, playController, resumeController);
    }
    
    public void start() {
        view.interact();
    }

    protected abstract View createView(StartController startController, PlayController playController, ResumeController resumeController);
    
}
