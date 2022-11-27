package io.github.ioni5.views.console;

import io.github.ioni5.controllers.ResumeController;
import io.github.ioni5.views.Message;
import utils.YesOrNotDialog;

public class ResumeView {

    public void interact(ResumeController resumeController) {
        boolean isResumed = new YesOrNotDialog().read(Message.RESUME.getMessage());
        if (isResumed) {
            resumeController.reset();
        } else {
            resumeController.next();
        }
    }

}
