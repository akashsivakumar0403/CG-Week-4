import java.util.*;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "java", "lambda");

        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());

        list.forEach(printUpperCase);
    }
}
