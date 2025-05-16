import java.util.Comparator;
import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    public String toString() {
        return name + " (Severity = " + severity + ")";
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> patients = new PriorityQueue<>();
        patients.add(new Patient("Ruchi", 3));
        patients.add(new Patient("Vandit", 5));
        patients.add(new Patient("Ami", 2));

        System.out.println("Order of treatment:");
        while (!patients.isEmpty()) {
            System.out.println(patients.poll());
        }
    }
}
