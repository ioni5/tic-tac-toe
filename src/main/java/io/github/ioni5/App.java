package io.github.ioni5;

import io.github.ioni5.models.Game;
import io.github.ioni5.views.View;

public class App {

    private Game game;
    
    private View view;

    public App() {
        game = new Game();
        view = new View(game);
    }

    public void start() {
        view.interact();
    }
    
    public static void main( String[] args ) {
        new App().start();
    }

}
