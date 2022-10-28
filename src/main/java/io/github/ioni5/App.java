package io.github.ioni5;

public class App {
    
    public static void main( String[] args ) {
        int numPlayers = -1;
        try {
            if (args.length != 1) {
                throw new Exception("\nUso: Main<Número de jugadores>\n");
            }
            numPlayers = Integer.parseInt(args[0]);
            if (!new Intervale(0, 2).includes(numPlayers)) {
                throw new Exception("\nNúmero de jugadores (0-2)\n");
            }
        } catch (Exception ex) {
            new Console().write(ex.getMessage());
            System.exit(0);
        }
        new TicTacToe(numPlayers).play();
    }

}
