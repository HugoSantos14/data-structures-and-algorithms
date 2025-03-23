package exercises.Set.nelio.Q01.application;

import exercises.Set.nelio.Q01.entities.LogEntry;

import java.io.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        final String path = "C:\\Windows\\Temp\\in.txt";
        final File file = new File(path);

        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                System.out.println("File created at: " + path);
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
                return;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<LogEntry> set = new HashSet<>();
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(" ");
                String username = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));

                set.add(new LogEntry(username, moment));

                line = br.readLine();
            }

            System.out.println("Total users: " + set.size());

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
