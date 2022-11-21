package utils;

public class Intervale {

    private int inferior;

    private int superior;

    public Intervale(int inferior, int superior) {
        this.inferior = inferior;
        this.superior = superior;
    }

    public boolean includes(int x) {
        return inferior <= x && x <= superior;
    }

    @Override
    public String toString() {
        return "[" + inferior + ", " + superior + "]";
    }

    public Intervale displaced() {
        return new Intervale(inferior + 1, superior + 1);
    }

}
