import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListReversal {
    public static <T> void reverseArrList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static <T> LinkedList<T> reverseLL(LinkedList<T> original) {
        LinkedList<T> reversed = new LinkedList<>();
        for (T item : original) {
            reversed.addFirst(item);
        }
        return reversed;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            arrayList.add(i);
        }
        System.out.println("Original ArrayList = " + arrayList);
        reverseArrList(arrayList);
        System.out.println("Reversed ArrayList = " + arrayList);

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            linkedList.add(i);
        }
        System.out.println("\nOriginal LinkedList = " + linkedList);
        LinkedList<Integer> reversedLL = reverseLL(linkedList);
        System.out.println("Reversed LinkedList = " + reversedLL);
    }
}
