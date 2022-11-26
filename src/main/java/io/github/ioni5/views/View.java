package io.github.ioni5.views;

public abstract class View {

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
