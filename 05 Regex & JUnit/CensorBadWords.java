import java.util.Arrays;
import java.util.List;

public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        String censored = input;

        for (String word : badWords) {
            censored = censored.replaceAll("(?i)\\b" + word + "\\b", "****");
        }

        System.out.println(censored);
    }
}
