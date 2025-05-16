import java.util.*;
import java.util.stream.*;
import java.text.DecimalFormat;

class Employee {
    int id;
    String name;
    String dept;
    double salary;

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String toString() {
        return id + " - " + name + " - " + dept + " - " + salary;
    }

    public String getDept() { return dept; }
    public double getSalary() { return salary; }
}

public class EmployeeProcessor {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ruchi", "Engineering", 90000),
                new Employee(2, "Vandit", "Engineering", 75000),
                new Employee(3, "Ami", "HR", 70000),
                new Employee(4, "Bhadrik", "Finance", 95000),
                new Employee(5, "Yash", "Engineering", 81000)
        );

        List<Employee> filtered = employees.stream().filter(e -> e.dept.equals("Engineering") && e.salary > 80000).collect(Collectors.toList());

        System.out.println("Filtered Employees (Engineering & Salary > 80000):");
        filtered.forEach(System.out::println);

        List<Employee> sorted = filtered.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());

        System.out.println("Sorted by Salary Descending:");
        sorted.forEach(System.out::println);

        Map<String, List<Employee>> grouped = sorted.stream().collect(Collectors.groupingBy(Employee::getDept));

        System.out.println("Grouped By Department:");
        grouped.forEach((dept, emps) -> {
            System.out.println(dept + " = ");
            emps.forEach(e -> System.out.println(" " + e));
        });

        Map<String, Double> avgSal = employees.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Average Salary per Department:");
        DecimalFormat df = new DecimalFormat("#.00");
        avgSal.forEach((dept, avg) -> System.out.println(dept + " = " + df.format(avg)));
    }
}
