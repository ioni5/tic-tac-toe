package io.github.ioni5;

import io.github.ioni5.controllers.PlayController;
import io.github.ioni5.controllers.ResumeController;
import io.github.ioni5.controllers.StartController;
import io.github.ioni5.views.gui.View;

public class GUITicTacToe extends TicTacToe {

    @Override
    protected View createView(StartController startController, PlayController playController, ResumeController resumeController) {
        return new View(startController, playController, resumeController);
    }

    public static void main(String[] args) {
        new GUITicTacToe().start();
    }
}
