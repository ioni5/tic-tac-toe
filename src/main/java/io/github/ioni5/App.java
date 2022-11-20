package io.github.ioni5;

import utils.Console;

public class App {

    public void play() {
        do {
            new TicTacToe().play();
        } while (this.again());
    }

    public boolean again() {
        Console console = new Console();
        String input;
        boolean error = false;
        do {
            input = console.read(Message.RESUME.getMessage());
            error = !input.equalsIgnoreCase("y") 
                && !input.equalsIgnoreCase("n");
        } while (error);
        return input.equalsIgnoreCase("y");
    }
    
    public static void main( String[] args ) {
        new App().play();
    }

}
