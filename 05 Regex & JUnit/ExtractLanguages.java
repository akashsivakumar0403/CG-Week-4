import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "Swift", "Kotlin");

        List<String> found = languages.stream()
                .filter(lang -> Pattern.compile("\\b" + Pattern.quote(lang) + "\\b").matcher(text).find())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", found));
    }
}
