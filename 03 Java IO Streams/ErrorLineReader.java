import java.io.*;

public class ErrorLineReader {
    public static void main(String[] args) {
        String filePath = "large.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found = " + filePath);
        } catch (IOException e) {
            System.out.println("An I/O error occurred = " + e.getMessage());
        }
    }
}
