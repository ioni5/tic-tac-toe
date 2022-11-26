package io.github.ioni5.views.console;

import io.github.ioni5.controllers.ResumeController;
import io.github.ioni5.views.Message;
import utils.YesOrNotDialog;

public class ResumeView {

    private ResumeController resumeController;

    public ResumeView(ResumeController resumeController) {
        this.resumeController = resumeController;
    }

    public boolean interact() {
        boolean isResumed = new YesOrNotDialog().read(Message.RESUME.getMessage());
        if (isResumed) {
            resumeController.reset();
        }
        return isResumed;
    }

}
