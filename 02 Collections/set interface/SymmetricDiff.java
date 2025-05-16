import java.util.Set;
import java.util.HashSet;

public class SymmetricDiff {
    public static <T> Set<T> getSymDiff(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        Set<T> temp = new HashSet<>(set2);

        result.removeAll(set2);
        temp.removeAll(set1);

        result.addAll(temp);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 4, 5);

        Set<Integer> symDiff = getSymDiff(set1, set2);
        System.out.println("Symmetric Difference = " + symDiff);
    }
}
