package io.github.ioni5.views.console;

import io.github.ioni5.controllers.PlayController;
import io.github.ioni5.controllers.ResumeController;
import io.github.ioni5.controllers.StartController;

public class View extends io.github.ioni5.views.View {
    
    private StartView startView;

    private PlayView playView;

    private ResumeView resumeView;

    public View(StartController startController, PlayController playController, ResumeController resumeController) {
        startView = new StartView(startController);
        playView = new PlayView(playController);
        resumeView = new ResumeView(resumeController);
    }

    public void interact() {
        startView.interact();
        do {
            playView.interact();
        } while (resumeView.interact());
    }

    @Override
    protected boolean isResumed() {
        return resumeView.interact();
    }

    @Override
    protected void getPlayView() {
        playView.interact();
    }

    @Override
    protected void getStartView() {
        startView.interact();
    }
}
