import java.util.*;

public class FreqElements {
    public static Map<String, Integer> countFreq(List<String> items) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String item : items) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }

        return freqMap;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> result = countFreq(input);

        System.out.println("Input = " + input);
        System.out.println("Frequencies = " + result);
    }
}
