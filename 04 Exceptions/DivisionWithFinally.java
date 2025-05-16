import java.util.Scanner;

public class DivisionWithFinally {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        try {
            System.out.print("Enter numerator = ");
            int num = scn.nextInt();
            System.out.print("Enter denominator = ");
            int den = scn.nextInt();

            int result = num / den;
            System.out.println("Result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        } finally {
            System.out.println("Operation completed");
        }
        scn.close();
    }
}
