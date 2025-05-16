interface SquareCalculator {
    int calculateSquare(int number);

    default void printResult(int number) {
        System.out.println("The square of " + number + " is " + calculateSquare(number));
    }
}

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        SquareCalculator square = (num) -> num * num;
        square.printResult(5);
    }
}
