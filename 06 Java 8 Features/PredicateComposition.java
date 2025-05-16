import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateComposition {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("example", "test", "functional", "predicate", "lambda", "stream");

        Predicate<String> lengthGreaterThan5 = s -> s.length() > 5;
        Predicate<String> containsSub = s -> s.contains("a");

        List<String> filtered = strings.stream().filter(lengthGreaterThan5.and(containsSub)).collect(Collectors.toList());

        System.out.println("Filtered strings = " + filtered);
    }
}
