package org.example.csv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVHandler {
    public static void writeResultsToCsv(String filePath, String[] header, List<String[]> data) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            csvWriter.writeNext(header);
            csvWriter.writeAll(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}