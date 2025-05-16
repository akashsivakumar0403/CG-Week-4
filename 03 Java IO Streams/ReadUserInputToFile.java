import java.io.*;

public class ReadUserInputToFile {
    public static void main(String[] args) {
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter name = ");
            String name = reader.readLine();

            System.out.print("Enter age = ");
            String age = reader.readLine();

            System.out.print("Enter programming language = ");
            String lang = reader.readLine();

            writer = new FileWriter("userInfo.txt");
            writer.write("Name = " + name + "\n");
            writer.write("Age = " + age + "\n");
            writer.write("Programming Language = " + lang + "\n");

            System.out.println("User Info save to 'userInfo.txt'");
        } catch (IOException e) {
            System.out.println("Error = " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException ex) {
                System.out.println("Error closing resources = " + ex.getMessage());
            }
        }
    }
}
