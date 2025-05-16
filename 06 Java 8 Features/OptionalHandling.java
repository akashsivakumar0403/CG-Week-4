import java.util.*;

public class OptionalHandling {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        Optional<Integer> maxNumber = findMax(numbers);

        maxNumber.ifPresentOrElse(
                max -> System.out.println("Maximum value = " + max),
                () -> System.out.println("The list is empty")
        );
    }

    public static Optional<Integer> findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo);
    }
}
