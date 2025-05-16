import java.util.*;

public class ListRotator {
    public static <T> List<T> rotateList(List<T> list, int k) {
        int n = list.size();
        if (n == 0 || k % n == 0) return list;

        k = k % n;
        List<T> rotated = new ArrayList<>();

        rotated.addAll(list.subList(k, n));
        rotated.addAll(list.subList(0, k));

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40 ,50);
        int rotateBy = 2;

        List<Integer> result = rotateList(input, rotateBy);

        System.out.println("Original List = " + input);
        System.out.println("Rotated by " + rotateBy + " = " + result);
    }
}
