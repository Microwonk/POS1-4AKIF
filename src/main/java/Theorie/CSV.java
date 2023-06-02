package Theorie;

import java.io.FileWriter;
import java.io.IOException;

public class CSV {
    public static void writeDataToCSV(String[][] data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] row : data) {
                StringBuilder csvRow = new StringBuilder();
                for (String value : row) {
                    csvRow.append("\"").append(value).append("\"").append(",");
                }
                csvRow.deleteCharAt(csvRow.length() - 1); // Remove the last comma
                csvRow.append("\n");
                writer.write(csvRow.toString());
            }
            System.out.println("Data has been written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
