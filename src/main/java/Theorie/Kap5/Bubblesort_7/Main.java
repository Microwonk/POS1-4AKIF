package Theorie.Kap5.Bubblesort_7;

import Theorie.CSV;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static String[][] data;

    public static void main(String[] args) {

        data = new String[10][3];
        data[0] = new String[]{"Case", "Element Count", "Time {nanoseconds}"};

        start(1000);
        start(10000);
        start(100000);

        CSV.writeDataToCSV(data, "src/main/java/Theorie/Kap5/Bubblesort_7/data.csv");

    }

    private static long measureSortingTime(int[] arr) {
        int[] copy = null;
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            copy = arr;
            bubbleSort(copy);
        }

        arr = copy;

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


    private static void bubbleSort(final int[] input) {
        boolean swapped;

        for (int i = 0; i < input.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;

                    swapped = true;
                }
            }

            // Wenn in einem Durchlauf keine Elemente mehr vertauscht wurden, ist das Array bereits sortiert
            if (!swapped) {
                break;
            }
        }
    }
}

