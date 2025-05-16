import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String ssn = "123-45-6789";

        // Regex pattern for valid SSN format (xxx-xx-xxxx)
        String pattern = "^(?!000|666|9\\d\\d)\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(ssn);

        if (m.matches()) {
            System.out.println("\"" + ssn + "\" is valid");
        } else {
            System.out.println("\"" + ssn + "\" is invalid");
        }
    }
}
