package io.github.ioni5;

public class App {

    public void play(int numPlayers) {
        do {
            new TicTacToe(numPlayers).play();
        } while (this.again());
    }

    public boolean again() {
        Console console = new Console();
        String input;
        boolean error = false;
        do {
            input = console.read("\n¿Quieres continuar? (y/n): ");
            error = !input.equalsIgnoreCase("y") 
                && !input.equalsIgnoreCase("n");
        } while (error);
        return input.equalsIgnoreCase("y");
    }
    
    public static void main( String[] args ) {
        int numPlayers = -1;
        try {
            if (args.length != 1) {
                throw new Exception("\nUso: Main<Número de jugadores>\n");
            }
            numPlayers = Integer.parseInt(args[0]);
            if (!new Intervale(0, TicTacToe.MAX_NUM_PLAYERS).includes(numPlayers)) {
                throw new Exception("\nNúmero de jugadores (0-" + TicTacToe.MAX_NUM_PLAYERS + ")\n");
            }
        } catch (Exception ex) {
            new Console().write(ex.getMessage());
            System.exit(0);
        }
        new App().play(numPlayers);
    }

}
