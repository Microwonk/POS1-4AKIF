package AM.Kryptografie_Abschluss.code;

public class MultiplikativesInverse_GGT {

    static int ggt (int a, int b) {
        int r = a%b;
        while (r != 0) {
            a = b;
            b = r;
            r = a&b;
        }
        return b;
    }

    static int multiplikativesInverse(final int m, final int a) {
        if (ggt(m, a) != 1) {
            throw new RuntimeException("M und A sind nicht teilerfremd");
        }
        int[] r = range(m);
        int[] c = range(m);
        int[] d = range(m);
        r[0] = m;
        r[1] = a;
        c[0] = 1;
        c[1] = 0;
        d[0] = 0;
        d[1] = 1;
        int i = 1;
        while (r[i] != 1){
            i++;
            int factor = r[i - 2] / r[i - 1];
            r[i] = r[i - 2] % r[i-1];
            c[i] = c[i - 2] - factor * c[i - 1];
            d[i] = d[i - 2]-factor * d[i - 1];
        }
        return d[i];
    }

    private static int[] range (final int num) {
        final int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i;
        }
        return res;
    }
}
