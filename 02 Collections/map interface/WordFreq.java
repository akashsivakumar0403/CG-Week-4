import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordFreq {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            System.out.println("Word Frequencies:");
            for (String word : wordCountMap.keySet()) {
                System.out.println(word + " = " + wordCountMap.get(word));
            }
        } catch (IOException e) {
            System.out.println("Error reading file = " + e.getMessage());
        }
    }
}
