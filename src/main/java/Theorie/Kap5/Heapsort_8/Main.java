package Theorie.Kap5.Heapsort_8;

import Theorie.CSV;

import java.util.Random;

public class Main {

    private static String[][] data;

    public static void main(String[] args) {

        data = new String[10][3];
        data[0] = new String[]{"Case", "Element Count", "Time {nanoseconds}"};

        start(1000);
        start(10000);
        start(100000);

        CSV.writeDataToCSV(data, "src/main/java/Theorie/Kap5/Heapsort_8/data.csv");
    }

    private static long measureSortingTime(int[] arr) {
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            heapSort(arr);
        }


        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000;
    }

    private static void start (final int elements) {
        Random r = new Random();
        int[] best = new int[elements];
        int[] avg = new int[elements];
        int[] worst = new int[elements];

        for (int i = 0; i < elements; i++) {
            best[i] = i;
            avg[i] = r.nextInt();
            worst[i] = elements - i - 1;
        }

        System.out.println("Best Case:");
        long bestCaseTime = measureSortingTime(best);
        System.out.println("Sorting time: " + bestCaseTime + " nanoseconds");

        System.out.println("\nAverage Case:");
        long averageCaseTime = measureSortingTime(avg);
        System.out.println("Sorting time: " + averageCaseTime + " nanoseconds");

        System.out.println("\nWorst Case:");
        long worstCaseTime = measureSortingTime(worst);
        System.out.println("Sorting time: " + worstCaseTime + " nanoseconds");

        if (elements == 1000) {
            data[1] = new String[]{"Best Case", String.valueOf(elements), String.valueOf(bestCaseTime)};
            data[4] = new String[]{"Average Case", String.valueOf(elements), String.valueOf(averageCaseTime)};
            data[7] = new String[]{"Worst Case", String.valueOf(elements), String.valueOf(worstCaseTime)};
        } else if (elements == 10000) {
            data[2] = new String[]{"Best Case", String.valueOf(elements), String.valueOf(bestCaseTime)};
            data[5] = new String[]{"Average Case", String.valueOf(elements), String.valueOf(averageCaseTime)};
            data[8] = new String[]{"Worst Case", String.valueOf(elements), String.valueOf(worstCaseTime)};
        } else {
            data[3] = new String[]{"Best Case", String.valueOf(elements), String.valueOf(bestCaseTime)};
            data[6] = new String[]{"Average Case", String.valueOf(elements), String.valueOf(averageCaseTime)};
            data[9] = new String[]{"Worst Case", String.valueOf(elements), String.valueOf(worstCaseTime)};
        }

    }


    private static void heapSort(final int[] input) {
        int n = input.length;

        // Build maximum heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            toHeap(input, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;

            // "Heapify" reduced heap
            toHeap(input, i, 0);
        }
    }

    private static void toHeap(int[] input, int n, int root) {
        int largest = root; // Initialize largest as the root
        int left = 2 * root + 1; // Left child
        int right = 2 * root + 2; // Right child

        // If the left child is larger than the root
        if (left < n && input[left] > input[largest]) {
            largest = left;
        }

        // If the right child is larger than the largest so far
        if (right < n && input[right] > input[largest]) {
            largest = right;
        }

        // If the largest element is not the root
        if (largest != root) {
            // Swap the root with the largest element
            int temp = input[root];
            input[root] = input[largest];
            input[largest] = temp;

            // Recursively "heapify"
            toHeap(input, n, largest);
        }
    }
}

