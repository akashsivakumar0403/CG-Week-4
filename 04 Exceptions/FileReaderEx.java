import java.io.*;

public class FileReaderEx {
    public static void main(String[] args) {
        File file = new File("data.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("File contents:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
