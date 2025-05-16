import java.io.*;

public class UpperToLowerCon {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));
        ) {
          String line;
          while ((line = reader.readLine()) != null) {
              writer.write(line.toLowerCase());
              writer.newLine();
          }
          System.out.println("File converted successfully, Output written to " + outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found = " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error occurred = " + e.getMessage());
        }
    }
}
