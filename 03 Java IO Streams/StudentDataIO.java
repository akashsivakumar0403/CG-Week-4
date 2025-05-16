import java.io.*;

public class StudentDataIO {
    public static void main(String[] args) {
        String fileName = "students.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Ruchi");
            dos.writeDouble(9.8);

            dos.writeInt(102);
            dos.writeUTF("Vandit");
            dos.writeDouble(8.5);

            dos.writeInt(103);
            dos.writeUTF("Ami");
            dos.writeDouble(7.8);

            System.out.println("Student data written successfully");
        } catch (IOException e) {
            System.out.println("I/O error occurred = " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nRetrieved Student Data:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll = " + roll + ", Name = " + name + ", GPA = " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error from reading from file = " + e.getMessage());
        }
    }
}
