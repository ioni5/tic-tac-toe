package io.github.ioni5.views.console;

import io.github.ioni5.controllers.Controller;
import io.github.ioni5.controllers.PlayController;
import io.github.ioni5.controllers.ResumeController;
import io.github.ioni5.controllers.StartController;
import io.github.ioni5.controllers.ControllerVisitor;

public class View extends io.github.ioni5.views.View implements ControllerVisitor {
    
    private StartView startView;

    private PlayView playView;

    private ResumeView resumeView;

    public View() {
        startView = new StartView();
        playView = new PlayView();
        resumeView = new ResumeView();
    }

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startView.interact(startController);
    }

    @Override
    public void visit(PlayController playController) {
        playView.interact(playController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        resumeView.interact(resumeController);
    }

}
