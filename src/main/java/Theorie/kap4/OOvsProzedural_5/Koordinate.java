package Theorie.kap4.OOvsProzedural_5;

public class Koordinate {

    private int x;
    private int y;

    public Koordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString () {
        return "x="+x+"y="+y;
    }

    public static void main (String[] args) {
        Koordinate k = new Koordinate(1, 123);
        System.out.println(k);
        k.set(12, 181);
        System.out.println(k);
    }

}