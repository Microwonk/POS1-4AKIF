package Theorie.Kap2.Zugriffszeiten_7;

import Theorie.Kap2.MyListElement_6.MyListElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        final int numOfElements = 1000;

        System.out.println("Number of Elements: " + numOfElements);
        MyListElement<Integer> l1 = new MyListElement<>();
        List<Integer> l2 = new ArrayList <>();
        List<Integer> l3 = new LinkedList <>();
        Integer[] a = new Integer[numOfElements];

        Random r = new Random();
        for (int i = 0; i < numOfElements; i++) {
            l1.add(r.nextInt(1000000));
            l2.add(r.nextInt(1000000));
            l3.add(r.nextInt(1000000));
            a[i] = r.nextInt(1000000);
        }

        // MyListElement
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int x = l1.get(numOfElements-1);
        }
        long end = System.nanoTime();
        long res = (end - start) / 1000;

        System.out.println("MyListElement: " + res + " nanoseconds");

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int x = l2.get(numOfElements-1);
        }
        end = System.nanoTime();
        res = (end - start) / 1000;

        System.out.println("ArrayList: " + res + " nanoseconds");

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int x = l3.get(numOfElements-1);
        }
        end = System.nanoTime();
        res = (end - start) / 1000;

        System.out.println("LinkedList: " + res + " nanoseconds");

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int x = a[numOfElements-1];
        }
        end = System.nanoTime();
        res = (end - start) / 1000;

        System.out.println("Array: " + res + " nanoseconds");
    }
}
