package io.github.ioni5.views.console;

import io.github.ioni5.controllers.Controller;
import io.github.ioni5.controllers.PlayController;
import io.github.ioni5.controllers.ResumeController;
import io.github.ioni5.controllers.StartController;

public class View extends io.github.ioni5.views.View {
    
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
        if (controller instanceof StartController) {
            startView.interact((StartController) controller);
        } else if (controller instanceof PlayController) {
            playView.interact((PlayController)controller);
        } else if (controller instanceof ResumeController) {
            resumeView.interact((ResumeController)controller);
        }
    }
}
