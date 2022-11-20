package utils;

import java.util.Scanner;

public class Console {

    private Scanner sc = new Scanner(System.in);

    public void write(String message) {
        System.out.print(message);
    }

    public void write(char message) {
        System.out.print(message);
    }

    public String read(String message) {
        String input = null;
        this.write(message);
        try {
            input = sc.nextLine();
        } catch (Exception ex) {
            this.write("\nError: entrada inválida.");
            System.exit(0);
        }
        return input;
    }

    public int readInt(String message) {
        int input = 0;
        try {
            input = Integer.parseInt(this.read(message));
        } catch (Exception ex) {
            this.write("\nError: entrada inválida.");
            System.exit(0);
        }
        return input;
    }

}
