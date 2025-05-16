import java.io.*;
import java.util.*;

class Emp implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String dept;
    private double salary;

    public Emp(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String toString() {
        return "Employee [ID = " + id + ", Name = " + name + ", Department = " + dept + ", Salary = " + salary + "]";
    }
}

public class EmpSerialization {
    private static final String FILE_NAME = "emps.ser";

    public static void main(String[] args) {
        List<Emp> emps = new ArrayList<>();
        emps.add(new Emp(101, "Ruchi", "HR", 1500000));
        emps.add(new Emp(102, "Vandit", "IT", 700000));
        emps.add(new Emp(103, "Ami", "Finance", 1000000));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(emps);
            System.out.println("Employees have been serialized to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Serialization Error = " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Emp> deserializedEmps = (List<Emp>) ois.readObject();
            System.out.println("\nDeserialized Employees:");
            for (Emp emp : deserializedEmps) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialized Error = " + e.getMessage());
        }
    }
}
