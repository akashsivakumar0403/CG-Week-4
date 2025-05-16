interface SumOperation {
    int add(int a, int b);
}

public class FunctionalInterface {
    public static void main(String[] args) {
        SumOperation sum = (a, b) -> a + b;

        int result = sum.add(10, 20);
        System.out.println("Sum = " + result);
    }
}
