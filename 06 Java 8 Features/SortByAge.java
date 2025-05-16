import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " - Age = " + age + ", Salary = " + salary;
    }
}

public class SortByAge {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Ruchi", 22, 50000),
                new Person("Vandit", 15, 60000),
                new Person("Ami", 47, 55000)
        );

        people.sort(Comparator.comparingInt(person -> person.age));

        people.forEach(System.out::println);
    }
}
