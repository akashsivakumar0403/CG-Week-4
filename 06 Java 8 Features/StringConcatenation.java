import java.util.function.BiFunction;

public class StringConcatenation {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenate = (str1, str2) -> str1 + " " + str2;

        String result = concatenate.apply("Hello", "World");
        System.out.println("Concatenated String = " + result);
    }
}
