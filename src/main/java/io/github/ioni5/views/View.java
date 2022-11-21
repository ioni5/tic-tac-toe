package io.github.ioni5.views;

import io.github.ioni5.models.Game;

public class View {
    
    private StartView startView;

    private PlayView playView;

    private ResumeView resumeView;

    public View(Game game) {
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
}
