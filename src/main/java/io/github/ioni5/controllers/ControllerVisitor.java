package io.github.ioni5.controllers;

public interface ControllerVisitor {

    void visit(StartController startController);

    void visit(PlayController playController);

    void visit(ResumeController resumeController);

}
