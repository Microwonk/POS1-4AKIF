package Theorie.Kap2.Deletable_Primes_10;


import java.math.BigInteger;
import java.util.Scanner;

public class DeletablePrimes {

    private static int ways;

    public DeletablePrimes() {
        ways = 0;
    }

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner scan = new Scanner(System.in);
        String prime = "0";

        while (true) {
            System.out.println("A Prime number: ");
            prime = scan.nextLine();
            if (!isPrime(prime)) {
                System.out.println("Not a Prime!!");
            }
            else break;
        }
        scan.close();

        if (prime.length() == 1) {
            System.out.println("Prime of one digit, cannot be deletable!");
        }
        else {
            deletablePrimeWays(prime);
            System.out.println("Ways: " + ways);
        }
    }


    private static String removeByIndex(String primeNumber, int index) {
        return new StringBuilder(primeNumber).deleteCharAt(index).toString();
    }

    private static boolean isPrime (String checkForPrime) {
        BigInteger checkedPrime = new BigInteger(checkForPrime);
        return checkedPrime.isProbablePrime(1);
    }


    private static void deletablePrimeWays (String prime) {
        int i = 0;
        String temp;

        while (i < prime.length()) {

            if (prime.length() == 1) {
                ways++;
            }
            else {
                //sets new String of temp
                temp = removeByIndex(prime, i);

                if (isPrime(temp)) {
                    //recursive call of deletablePrimeWays
                    deletablePrimeWays(temp);
                }
            }
            i++;
        }
        return;
    }
}
