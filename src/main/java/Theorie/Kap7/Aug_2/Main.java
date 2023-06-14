package Theorie.Kap7.Aug_2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Funktion zum Verdoppeln von Integer-Zahlen
        UnaryOperator<Integer> doubleFunction = num -> num * 2;

        // Funktion zur Wurzelberechnung von Double-Zahlen
        Function<Integer, Double> squareRootFunction = Math::sqrt; // sonst: (n) -> Math.sqrt(n);

        // Funktion zum Aufsummieren von Double-Zahlen
        BinaryOperator<Double> sumFunction = Double::sum; // sonst: (num1, num2) -> num1 + num2

        // Kombination der Funktionen: Verdoppeln, Wurzelberechnung, Aufsummieren
        Double result = numbers.stream()
                .map(doubleFunction)
                .map(squareRootFunction)
                .reduce(0.0, sumFunction);

        System.out.println("Ergebnis: " + result);
    }
}
