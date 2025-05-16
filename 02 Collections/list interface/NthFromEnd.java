import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class NthFromEnd {
    public static <T> T getNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0) throw new IllegalArgumentException("N must be positive");

        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();

        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("List is shorter than N");
            }
            first.next();
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        String result = getNthFromEnd(list, N);
        System.out.println("Nth Element from End (" + N + ") = " + result);
    }
}
