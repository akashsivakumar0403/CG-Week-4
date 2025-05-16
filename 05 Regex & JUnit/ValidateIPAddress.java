import java.util.regex.*;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String input = "192.168.1.1";
        String ipPattern = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";
        boolean isValid = Pattern.matches(ipPattern, input);
        System.out.println(isValid ? "Valid IP" : "Invalid IP");
    }
}
