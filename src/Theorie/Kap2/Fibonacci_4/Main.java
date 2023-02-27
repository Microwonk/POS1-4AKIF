package Theorie.Kap2.Fibonacci_4;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        start();
        loopUntilErr();
    }

    private static void loopUntilErr() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int a = calcFibonacciFunctional(i);
            int b = calcFibonacci(i);

            System.out.println("Functional: " + b
                    + "\nLooping: " + a);

            // Error found at 47
            if (b < 0) {
                if (a < 0) {
                    throw new RuntimeException("Functional and Normal Calc Error at: " + i);
                }
                throw new RuntimeException("Normal Calc Error at: " + i);
            } else if (a < 0) {
                throw new RuntimeException("Functional Calc Error at: " + i);
            }
        }
    }

    private static void start() {
        final Scanner scan = new Scanner(System.in);
        int n;

        System.out.println("Wievielte Zahl der Fibonacci Sequenz?");
        try {
            n = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            n = 0;
        }
        System.out.println("Functional: " + calcFibonacciFunctional(n)
                + "\nLooping: " + calcFibonacci(n));
    }

    private static int calcFibonacci(final int n) {
        int[] fib = new int[]{1, 1};
        if (n == 1 || n == 2) return fib[1];

        for (int i = 1; i < n; i++) {
            fib = new int[]{fib[1], fib[0] + fib[1]};
        }
        return fib[0];
    }

    private static int calcFibonacciFunctional(final int n) {
        return Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .skip(n)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)[0];
    }
}
