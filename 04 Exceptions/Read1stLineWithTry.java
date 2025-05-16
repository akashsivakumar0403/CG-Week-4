import java.io.*;

public class Read1stLineWithTry {
    public static void main(String[] args) {
        String file = "info.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            if (line != null) {
                System.out.println("First line = " + line);
            } else {
                System.out.println("File is empty");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
