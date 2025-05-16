import java.util.Set;
import java.util.HashSet;

public class SetOperations {
    public static <T> Set<T> getUnion(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    public static <T> Set<T> getIntersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> union = getUnion(set1, set2);
        Set<Integer> intersection = getIntersection(set1, set2);

        System.out.println("Union = " + union);
        System.out.println("Intersection = " + intersection);
    }
}
