package exercises.Map.nelio.Q01;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        final Map<String, Integer> candidates = new LinkedHashMap<>();
        final File file = new File("C:\\db\\candidates.txt");

        // Preencher o Map com os dados do arquivo .txt
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                String[] split = line.split(",");
                String name = split[0];
                Integer votes = Integer.parseInt(split[1]);
                candidates.put(name, candidates.getOrDefault(name, 0) + votes);
                line = br.readLine();
            }

            System.out.println("CANDIDATOS:");
            for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " votos");
            }
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
