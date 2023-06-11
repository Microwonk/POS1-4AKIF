package Theorie.Kap6._3_Geometrie;

public abstract class AFigur {
    protected boolean eckig;

    public AFigur (boolean eckig) {
        this.eckig = eckig;
    }

    public boolean isEckig () {
        return eckig;
    }
}
