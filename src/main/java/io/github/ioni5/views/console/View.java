package io.github.ioni5.views.console;

import io.github.ioni5.models.Game;

public class View extends io.github.ioni5.views.View {
    
    private StartView startView;

    private PlayView playView;

    private ResumeView resumeView;

    public View(Game game) {
        super(game);
        startView = new StartView(game);
        playView = new PlayView(game);
        resumeView = new ResumeView(game);
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
