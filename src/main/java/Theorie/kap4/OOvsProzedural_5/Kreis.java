package Theorie.kap4.OOvsProzedural_5;

public class Kreis {
    static class Mitte {
        int x;
        int y;
        public Mitte (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString () {
            return "Mitte{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    };
    private Mitte mitte;
    private int radius;

    public Kreis (int x, int y, int radius) {
        this.mitte = new Mitte(x, y);
        this.radius = radius;
    }

    public void setPosition(int x, int y) {
        this.mitte.x = x;
        this.mitte.y = y;
    }

    @Override
    public String toString () {
        return "Kreis{" +
                "mitte=" + mitte +
                ", radius=" + radius +
                '}';
    }

    public static void main (String[] args) {
        Kreis kreis = new Kreis(1,2, 17);
        System.out.println(kreis);
        kreis.setPosition(3, 7);
        System.out.println(kreis);
    }
}
