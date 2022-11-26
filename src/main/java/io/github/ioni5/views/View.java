package io.github.ioni5.views;

import io.github.ioni5.models.Game;

public abstract class View {

    protected Game game;

    public View(Game game) {
        this.game = game;
    }

    public void interact() {
        this.getStartView();
        do {
            this.getPlayView();
        } while (this.isResumed());
    }

    protected abstract boolean isResumed();

    protected abstract void getPlayView();

    protected abstract void getStartView();
}
