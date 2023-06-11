package Theorie.Kap6._3_Geometrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeoTester {

    private final List<AFigur> figuren;

    public GeoTester () {
        this.figuren = new ArrayList <>();
    }

    public void add (AFigur... figures) {
        figuren.addAll(Arrays.asList(figures));
    }

    public double calcCircumference () {
        double sum = 0;
        for (AFigur f: figuren) {
            sum += ((FigurHelper) f).getUmfang();
        }
        return sum;
    }

    public double calcArea () {
        double sum = 0;
        for (AFigur f: figuren) {
            sum += ((FigurHelper) f).getArea();
        }
        return sum;
    }

    public List<Kreis> getKreise() {
        return figuren.stream()
                .filter(a -> !a.isEckig())
                .map(a -> (Kreis) a) // Cast each element to Kreis
                .collect(Collectors.toList());
    }

    public List<Dreieck> getDreiecke() {
        return figuren.stream()
                .filter(AFigur::isEckig)
                .map(a -> (Dreieck) a) // Cast each element to Dreieck
                .collect(Collectors.toList());
    }


    public static void main (String[] args) {

        GeoTester g = new GeoTester();

        g.add(new Dreieck(9, 1, 3),
                new Dreieck(1, 2, 3),
                new Dreieck(2, 3, 4),
                new Dreieck(4, 5, 6),
                new Dreieck(5, 6, 7),
                new Kreis(1),
                new Kreis(2),
                new Kreis(3),
                new Kreis(4),
                new Kreis(5),
                new Kreis(6),
                new Kreis(7),
                new Kreis(8));

        System.out.println("Alle:");
        g.figuren.forEach(System.out::println);

        System.out.println("\nDreiecke:");
        g.getDreiecke().forEach(System.out::println);

        System.out.println("\nKreise:");
        g.getKreise().forEach(System.out::println);

        System.out.println("\ninsg. Fläche: " + (g.calcArea()) + " insg. Umfang: " + g.calcCircumference());
        /*
        Verbesserungen: entweder Interface in AFigur implementieren, oder die Methoden aus FigurHelper in die abstrakte Klasse einfügen.
         */
    }
}
