package Theorie.Kap5.Dijkstra;

public class Place {

    private int cost;
    private String place;

    public Place (int cost, String place) {
        this.cost = cost;
        this.place = place;
    }

    public int cost () {
        return cost;
    }

    public String place () {
        return place;
    }

    public static class NullPlace extends Place {

        public final static NullPlace place = new NullPlace();

        private NullPlace () {
            super(0, null);
        }
    }
}