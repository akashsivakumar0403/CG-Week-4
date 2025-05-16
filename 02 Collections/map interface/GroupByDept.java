import java.util.*;

class Emp {
    private String name;
    private String dept;

    public Emp(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    public String getName() { return name; }
    public String getDept() { return dept; }
    public String toString() { return name; }
}

public class GroupByDept {
    public static void main(String[] args) {
        List<Emp> emps = Arrays.asList(
                new Emp("Ruchi", "IT"),
                new Emp("Vandit", "HR"),
                new Emp("Ami", "HR"),
                new Emp("Bhadrik", "Finance")
        );

        Map<String, List<Emp>> grouped = groupByDept(emps);

        for (Map.Entry<String, List<Emp>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static Map<String, List<Emp>> groupByDept(List<Emp> emps) {
        Map<String, List<Emp>> deptMap = new HashMap<>();

        for (Emp emp : emps) {
            deptMap.computeIfAbsent(emp.getDept(), k -> new ArrayList<>()).add(emp);
        }

        return deptMap;
    }
}
