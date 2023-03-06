package Theorie.Kap2.Deletable_Primes_10;


import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class DeletablePrimes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String prime;

        while (true) {
            System.out.println("A Prime number: ");
            prime = scan.nextLine();
            if (!new BigInteger(prime).isProbablePrime(1)) {
                System.out.println("Not a Prime!");
            } else break;
        }
        scan.close();

        System.out.println(prime.length() == 1 ? "Prime of one digit, cannot be deletable!"
                : "Ways: " + deletablePrimeWays(prime));
    }
    private static int deletablePrimeWays (final String prime) {
        int ways = 0;
        final Stack<String> stack = new Stack<>();
        stack.push(prime);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            for (int i = 0; i < current.length(); i++) {
                if (current.length() == 1) {
                    ways++;
                } else {
                    String temp = new StringBuilder(current).deleteCharAt(i).toString();
                    if (new BigInteger(temp).isProbablePrime(1)) {
                        stack.push(temp);
                    }
                }
            }
        }
        return ways;
    }
}