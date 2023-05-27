package Theorie.Kap5.BinarySearch_5;

import pos.theorie.sose.k6.MyTreeElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final MyTreeElement mte = new MyTreeElement();
    private static final List<Integer> list = new ArrayList <>();

    public static void main (String[] args) {
        for (int i = 0; i < 20; i++) {
            start();
        }
    }

    private static void start () {
        for (int i = 0; i < 100; i++) {
            list.add(new Random().nextInt(0, 10001));
            mte.add(list.get(i));
        }

        int sumForLinear = 0;
        int sumForBinary = 0;

        for (int i = 0; i < 1000; i++) {
            int search = list.get(new Random().nextInt(100));
            int j = 0;

            while (true) {
                if (search == list.get(j)) {
                    sumForLinear += j;
                    break;
                }
                j++;
            }

            sumForBinary += mte.count(search);
        }
        sumForLinear = sumForLinear / 1000;
        sumForBinary = sumForBinary / 1000;

        System.out.println("Binary search: " + sumForBinary);
        System.out.println("Linear search: " + sumForLinear);
    }
}
