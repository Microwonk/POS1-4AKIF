package Theorie.Kap7.Aufg_1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        // erst filtern ist am schnellsten

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .peek(e -> System.out.println("Filter: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Uppercase: " + e))
                .sorted()
                .forEach(System.out::println);
        /*  Filter: c2
            Uppercase: C2
            Filter: c1
            Uppercase: C1
            C1
            C2      */

        // läuft parallel, heißt sie werden nicht iterativ/nacheinander bearbeitet -> parallel!!
        myList.parallelStream()
                .filter(s -> s.startsWith("c"))
                .peek(e -> System.out.println("Filter: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Uppercase: " + e))
                .sorted()
                .forEachOrdered(System.out::println);
        /*  Filter: c1
            Filter: c2
            Uppercase: C2
            Uppercase: C1
            C1
            C2    */

        // langsamer, mehr Aufrufe
        myList.stream()
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Uppercase: " + e))
                .filter(s -> s.startsWith("C"))
                .peek(e -> System.out.println("Filter: " + e))
                .sorted()
                .forEach(System.out::println);
        /*  Uppercase: A1
            Uppercase: A2
            Uppercase: B1
            Uppercase: C2
            Filter: C2
            Uppercase: C1
            Filter: C1
            C1
            C2     */

    }
}
