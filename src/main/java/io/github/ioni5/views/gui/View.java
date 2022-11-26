package io.github.ioni5.views.gui;

import io.github.ioni5.controllers.PlayController;
import io.github.ioni5.controllers.ResumeController;
import io.github.ioni5.controllers.StartController;

public class View extends io.github.ioni5.views.View {

    public View(StartController startController, PlayController playController, ResumeController resumeController) {
        
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
