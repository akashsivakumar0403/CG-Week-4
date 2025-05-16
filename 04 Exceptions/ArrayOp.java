import java.util.Scanner;

public class ArrayOp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[] nums = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter index to retrieve = ");
            int index = scn.nextInt();

            int value = nums[index];
            System.out.println("Value at index " + index + " = " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized");
        } finally {
            scn.close();
        }
    }
}
