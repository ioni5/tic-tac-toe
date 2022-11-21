package utils;

public class YesOrNotDialog {

    private static String AFIRMATIVE_ANSWER = "y";

    private static String NEGATIVE_ANSWER = "n";

    public boolean read(String message) {
        Console console = new Console();
        String input;
        boolean error = false;
        do {
            input = console.read(message);
            error = !input.equalsIgnoreCase(AFIRMATIVE_ANSWER) 
                && !input.equalsIgnoreCase(NEGATIVE_ANSWER);
        } while (error);
        return input.equalsIgnoreCase(AFIRMATIVE_ANSWER);
    }

}
