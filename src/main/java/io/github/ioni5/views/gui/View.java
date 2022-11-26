package io.github.ioni5.views.gui;

import io.github.ioni5.models.Game;

public class View extends io.github.ioni5.views.View {

    public View(Game game) {
        super(game);
    }

    @Override
    protected boolean isResumed() {
        return false;
    }

    @Override
    protected void getPlayView() {
        
    }

    @Override
    protected void getStartView() {
        
    }
    
}
