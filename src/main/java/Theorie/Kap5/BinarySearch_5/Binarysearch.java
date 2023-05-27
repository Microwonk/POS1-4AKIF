package Theorie.Kap5.BinarySearch_5;

import java.util.Arrays;
import java.util.Random;

public class Binarysearch {

    public static void main (String[] args) {
        int[] data = createRandomArray(100000, 10000);
        System.out.println(Arrays.toString(data));

        int inp = data[new Random().nextInt(0, 100000)];
        System.out.println(binarySearch(data, inp) + " " + inp);
        System.out.println();

        System.out.println(binarySearchRec(data, inp, 0, data.length) + " " + inp);
    }

    private static int[] createRandomArray (int size, int bound) {
        final int[] arr = new int[size];
        final Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(bound);
        }
        return Arrays.stream(arr).sorted().toArray();
    }

    private static int binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (data[middle] == target) {
                return middle;
            } else if (data[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    private static int binarySearchRec(int[] data, int target, int left, int right) {
        if (left > right) return -1;

        int middle = (left + right) / 2;

        if (data[middle] == target) {
            return middle;
        } else if (data[middle] < target) {
            return binarySearchRec(data, target, middle + 1, right);
        } else {
            return binarySearchRec(data, target, left, middle - 1);
        }
    }
}
