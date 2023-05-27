package Theorie.EpicCodingChallenges.SmartGridL2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(input());
        int[] minutes = new int[Integer.parseInt(br.readLine())];
        //   task id  time taken
        Map<Integer, Integer> tasks = new HashMap <>();

        for (int i = 0; i < minutes.length; i++) { // read the minute prices
            minutes[i] = Integer.parseInt(br.readLine());
        }

        br.readLine(); // get rid of the number of entries

        while (true) { // read the tasks
            String curr = br.readLine();
            if (curr == null) break;
            String[] newTask = curr.split(" ");
            tasks.put(Integer.parseInt(newTask[0]), Integer.parseInt(newTask[1]));
        }

        for (Integer taskID: tasks.keySet()) {
            int sum,
            min = Integer.MAX_VALUE,
            startID = 0;

            for (int i = 0; i < minutes.length; i++) {
                try {
                    // summe zwischen i und länge + i
                    sum = Arrays.stream(minutes, i, (i + 1 + tasks.get(taskID))).sum();
                    if (sum < min) {
                        min = sum;
                        startID = i; // id, an der das neue minimum gefunden wird
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    tasks.replace(taskID, startID + 1); // speichern der günstigsten startID
                    break;
                }
            }
        }

        System.out.println(tasks.size());
        tasks.forEach((k, v) -> System.out.println(k + " " + v));
    }

    // simple input prompt
    private static FileReader input () throws Exception {
        System.out.println("file: ");
            return new FileReader(
                    "src/main/java/Theorie/EpicCodingChallenges/SmartGridL2/test/level2_"
                            + new Scanner(System.in).nextLine() + ".in");
    }
}
