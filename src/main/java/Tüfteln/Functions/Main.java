package Tüfteln.Functions;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Double, Function<Double, Double>> weight = mass -> gravity -> mass * gravity /10;

        Function<Double, Double> weightOnEarth = weight.apply(9.81);
        System.out.println("My weight on Earth: " + weightOnEarth.apply(60.0));

        Function<Double, Double> weightOnMars = weight.apply(3.75);
        System.out.println("My weight on Mars: " + weightOnMars.apply(60.0));
    }
}
