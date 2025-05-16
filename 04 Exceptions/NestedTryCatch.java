import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] nums = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter index to access = ");
            int index = scn.nextInt();

            try {
                System.out.print("Enter divisor = ");
                int divisor = scn.nextInt();

                int result = nums[index] / divisor;
                System.out.println("Result = " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index");
        }
    }
}
