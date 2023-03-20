package AM.Kryptografie_Abschluss.code;

import java.util.Scanner;

import static AM.Kryptografie_Abschluss.code.MultiplikativesInverse_GGT.ggt;
import static AM.Kryptografie_Abschluss.code.MultiplikativesInverse_GGT.multiplikativesInverse;

//TODO everything
public class RsaKeysAndDecoding {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("p eingeben:");
        final int p = Integer.parseInt(scanner.nextLine());
        System.out.println("q eingeben:");
        final int q = Integer.parseInt(scanner.nextLine());
        final int n = p * q;
        final int m = (p-1)*(q-1);
        int a;

        do {
            System.out.println("Gib a ein (teilerfremd zu m):");
            a = Integer.parseInt(scanner.nextLine());
            System.out.println(a + "ist nicht teilerfremd zu m: " + m + " sie haben einen ggT von " + ggt(m, a));
        } while (ggt(m, a) != 1);

        System.out.println();
        System.out.println("Der öffentliche Schlüssel besteht aus den Zahlen n = " + n + " und a = " + a);
        System.out.println();

        final int b = multiplikativesInverse(a, m);
    }
}
