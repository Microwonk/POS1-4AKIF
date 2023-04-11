package VALE.randomArray;

import java.util.*;
import java.util.function.IntPredicate;

public class RandomArray {
    public static void main (String[] args) {
        int[][] arr = randArray();
        Arrays.stream(arr).forEach(candidate -> System.out.println(Arrays.toString(candidate)));
        System.out.println();

        sort2dArray(arr);
        Arrays.stream(arr).forEach(candidate -> System.out.println(Arrays.toString(candidate)));
    }

    public static void sort2dArray(int[][] arr) {
        final int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (arr[i][j] < arr[k][l]) {
                            int temp = arr[i][j];
                            arr[i][j] = arr[k][l];
                            arr[k][l] = temp;
                        }
                    }
                }
            }
        }
    }

    private static int[][] randArray () {
        final Random r = new Random();
        final int[][] res = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                res[i][j] = r.ints(1, 1001)
                        .filter(n -> Arrays.stream(res)
                                .flatMapToInt(Arrays::stream)
                                .noneMatch(equalsTo(n)))
                        .findFirst()
                        .orElseThrow();
            }
        }
        return res;
    }

    public static IntPredicate equalsTo(int target) {
        return x -> x == target;
    }
}
