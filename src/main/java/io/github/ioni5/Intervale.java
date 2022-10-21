package io.github.ioni5;

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

}
