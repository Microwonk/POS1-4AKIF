package Theorie.Kap6._2_Grundrechenarten;

public class Bruch implements Grundrechenarten {

    public static final Bruch HALF = new Bruch(1, 2);
    public static final Bruch ONE = new Bruch(1,1);
    public static final Bruch ZERO = new Bruch(0,0);

    private final int zahler;
    private final int nenner;

    public Bruch () {
        this(1,1);
    }

    public Bruch (int zahler, int nenner) {
        this.zahler = zahler;
        this.nenner = nenner;
    }

    public Bruch (int zahler) {
        this(zahler, 1);
    }

    @Override
    public Bruch add(Bruch b) {
        return kuerzeBruch(new Bruch(
                this.zahler * b.nenner + b.zahler * this.nenner
                , this.nenner * b.nenner)
        );
    }

    @Override
    public Bruch multiply(Bruch b) {
        return kuerzeBruch(new Bruch(
                this.zahler * b.zahler
                        , this.nenner * b.nenner)
        );
    }

    @Override
    public Bruch subtract(Bruch b) {
        return kuerzeBruch(new Bruch(
                this.zahler * b.nenner - b.zahler * this.nenner
                , this.nenner * b.nenner)
        );
    }

    @Override
    public Bruch divide(Bruch b) {
        return kuerzeBruch(new Bruch(
                this.zahler * b.nenner
                , this.nenner * b.zahler)
        );
    }

    private Bruch kuerzeBruch(Bruch bruch) {
        final int ggT = berechneGGT(bruch.zahler, bruch.nenner);
        return new Bruch(bruch.zahler / ggT, bruch.nenner / ggT);
    }

    // Hilfsmethode zum Berechnen des größten gemeinsamen Teilers (GGT)
    private int berechneGGT(int a, int b) {
        return (b == a) ? a : berechneGGT(b, a % b);
    }

    @Override
    public String toString () {
        StringBuilder s = new StringBuilder();
        for (char c : String.valueOf(Math.max(nenner, zahler)).toCharArray()) {
            s.append("-");
        }
        return " " + zahler + "\n-" + s + "-\n " + nenner;
    }
}
