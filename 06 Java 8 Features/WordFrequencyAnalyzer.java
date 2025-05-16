import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class WordFrequencyAnalyzer {

    public static void main(String[] args) {
        String text = "Java is a powerful language. Java supports object-oriented programming. "
                + "Streams and lambda expressions make Java concise. Java is used in enterprise applications.";

        List<String> words = Arrays.stream(text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+")).collect(Collectors.toList());

        Map<String, Long> wordFrequencies = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int topN = 3;
        System.out.println("Top " + topN + " most frequent words:");
        wordFrequencies.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())).limit(topN).forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));

        List<Map.Entry<String, Long>> sortedEntries = wordFrequencies.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

        if (sortedEntries.size() >= 2) {
            Map.Entry<String, Long> secondMostFrequent = sortedEntries.get(1);
            System.out.println("Second most frequent word:");
            System.out.println(secondMostFrequent.getKey() + " = " + secondMostFrequent.getValue());
        } else {
            System.out.println("Not enough distinct words to determine the second most frequent");
        }
    }
}
