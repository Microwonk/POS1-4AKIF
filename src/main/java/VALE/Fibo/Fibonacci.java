package VALE.Fibo;

import java.util.Arrays;

public class Fibonacci {
    public static void main (String[] args) {
        System.out.println(Arrays.toString(getFibo(6)));
        printFibohneArr(17);
    }

    private static int[] getFibo (int n) {
        final int[] toReturn = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 1 || i == 2) {
                toReturn[i] = 1;
            } else if (i != 0) {
                toReturn[i] = toReturn[i-1] + toReturn[i-2];
            }
        }
        return toReturn;
    }

    private static void printFibohneArr (int n) {
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            if (i == 1 || i == 2) {
                System.out.print(1 + ", ");
            } else if (i != 0) {
                int temp = b;
                b += a;
                a = temp;
                System.out.print(b + ", ");
            }
        }
    }
}

