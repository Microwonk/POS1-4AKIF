package Theorie.Kap6._3_Geometrie;

public class Kreis extends AFigur implements FigurHelper {

    private double r;

    public Kreis (double radius) {
        super(false);
        r = radius;
    }

    @Override
    public double getUmfang () {
        return 2 * r * Math.PI;
    }

    @Override
    public double getArea () {
        return Math.pow(r, 2) * Math.PI;
    }

    @Override
    public String toString () {
        return "Kreis{" +
                "r=" + r +
                ", eckig=" + eckig +
                '}';
    }
}
