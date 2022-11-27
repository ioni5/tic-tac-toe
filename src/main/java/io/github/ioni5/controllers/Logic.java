package io.github.ioni5.controllers;

import java.util.HashMap;
import java.util.Map;

import io.github.ioni5.models.Game;

public class Logic {
    
    private State state;

    private Map<StateValue, Controller> controllers;

    public Logic() {
        state = new State();
        controllers = new HashMap<>();
        Game game = new Game();
        controllers.put(StateValue.INITIAL, new StartController(game, state));
        controllers.put(StateValue.IN_GAME, new PlayController(game, state));
        controllers.put(StateValue.RESUME, new ResumeController(game, state));
        controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return controllers.get(state.getValue());
    }
}
