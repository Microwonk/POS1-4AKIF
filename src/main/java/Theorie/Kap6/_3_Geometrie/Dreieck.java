package Theorie.Kap6._3_Geometrie;

public class Dreieck extends AFigur implements FigurHelper {

    private double a;
    private double b;
    private double c;

    public Dreieck (double a, double b, double c) {
        super(true);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getUmfang () {
        return a + b + c;
    }

    @Override
    public double getArea () {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString () {
        return "Dreieck{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", eckig=" + eckig +
                '}';
    }
}
