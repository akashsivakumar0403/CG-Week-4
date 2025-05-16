import java.util.Scanner;

public class HexColorValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String color = scanner.nextLine();
        if (color.matches("^#([A-Fa-f0-9]{6})$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
