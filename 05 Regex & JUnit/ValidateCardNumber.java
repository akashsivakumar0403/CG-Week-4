import java.util.regex.*;

public class ValidateCardNumber {
    public static void main(String[] args) {
        String input = "5123456789012345";
        String visaPattern = "^4\\d{15}$";
        String masterCardPattern = "^5\\d{15}$";

        if (input.matches(visaPattern)) {
            System.out.println("Valid Visa Card");
        } else if (input.matches(masterCardPattern)) {
            System.out.println("Valid MasterCard");
        } else {
            System.out.println("Invalid Card");
        }
    }
}
