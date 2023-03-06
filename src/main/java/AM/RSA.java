package AM;

import java.util.Arrays;

public class RSA {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        System.out.println(Arrays.toString(getPrivateRSAKey(5, 13, 11)));
    }

    private static int[] getPrivateRSAKey(final int prim1, final int prim2, final int e) {
        final int[] keys = new int[2];
        final int n = prim1 * prim2;
        final int m = (prim1 - 1) * (prim2 - 1);
        return null;
    }
}
