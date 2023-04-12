package Theorie.kap4.Division_3;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        System.out.println(Arrays.toString(ganzzahlDivision(10, 3)));
        Tuple <Integer> a = ganzzahlDivisionTuple(12, 7);
        System.out.println(a.one + " " + a.two);
    }

    /**
     *
     * @param dividend
     * @param divisor
     * @return [quotient, rest]
     */
    private static int[] ganzzahlDivision(final int dividend, final int divisor) {
        return new int[]{dividend/divisor, dividend%divisor};
    }

    /**
     *
     * @param dividend
     * @param divisor
     * @return [quotient, rest]
     */
    private static Tuple<Integer> ganzzahlDivisionTuple(final int dividend, final int divisor) {
        return new Tuple<>(dividend/divisor, dividend%divisor);
    }

    /**
     * @param <E> Element des Tuples
     */
    private static class Tuple<E> {

        public E one; // Quotient
        public E two; // Rest

        public Tuple(E one, E two) {
            this.one = one;
            this.two = two;
        }
    }
}
