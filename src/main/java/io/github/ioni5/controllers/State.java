package io.github.ioni5.controllers;

public class State {
    
    private StateValue value;

    public State() {
        this.reset();
    }

    public void next() {
        value = StateValue.values()[value.ordinal() + 1];
    }

    public void reset() {
        value = StateValue.INITIAL;
    }

    public StateValue getValue() {
        return value;
    }
}
