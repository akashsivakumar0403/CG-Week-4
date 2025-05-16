import java.util.Scanner;

class InvalidAgeEx extends Exception {
    public InvalidAgeEx(String msg) {
        super(msg);
    }
}

public class AgeValidator {
    public static void validateAge(int age) throws InvalidAgeEx {
        if (age < 18) {
            throw new InvalidAgeEx("Age must be 18 or above");
        } else {
            System.out.println("Access granted");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        try {
            System.out.print("Enter age = ");
            int age = scn.nextInt();

            validateAge(age);
        } catch (InvalidAgeEx e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input");
        } finally {
            scn.close();
        }
    }
}
