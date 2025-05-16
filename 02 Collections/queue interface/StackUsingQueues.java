import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class StackUsingQ {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQ() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int top = queue1.poll();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int top = queue1.peek();

        queue2.add(queue1.poll());

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class StackUsingQueues {
    public static void main(String[] args) {
        StackUsingQ stack = new StackUsingQ();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pop = " + stack.pop());

        stack.push(4);

        System.out.println("Top = " + stack.top());
        System.out.println("Pop = " + stack.pop());

        System.out.println("Pop = " + stack.pop());
        System.out.println("Pop = " + stack.pop());
    }
}
