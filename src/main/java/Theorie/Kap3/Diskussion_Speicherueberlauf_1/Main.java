package Theorie.Kap3.Diskussion_Speicherueberlauf_1;

public class Main {
    public static void main (String[] args) {
        // for a stack overflow
        //stackOverflow(1);
        System.out.println("Used Heap: " + findCurrentHeapUsed() + " bytes");
        System.out.println("Maximum Heap: " + findCurrentMaxHeap() + " bytes");
        heapOverflow();
    }

    private static void stackOverflow (int i) {
        System.out.println(i);
        stackOverflow(i + 1);
    }

    private static void heapOverflow() {
        byte[] lol = new byte[Integer.MAX_VALUE];
    }

    private static long findCurrentMaxHeap () {
        return Runtime.getRuntime().maxMemory();
    }

    private static long findCurrentHeapUsed () {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}
