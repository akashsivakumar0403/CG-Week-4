import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordFreqCounter {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            List<Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
            sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("\nTop 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

            System.out.println("\nTotal unique words = " + wordCountMap.size());
        } catch (FileNotFoundException e) {
            System.out.println("File not found = " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading file");
        }
    }
}
