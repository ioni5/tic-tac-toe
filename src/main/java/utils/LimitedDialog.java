package utils;

public class LimitedDialog {

    private Intervale limit;

    public LimitedDialog(Intervale limit) {
        this.limit = limit;
    }

    public int read(String message) {
        Console console = new Console();
        int input;
        do {
            input = console.readInt(message);
        } while (!limit.includes(input));
        return input;
    }
    
}
