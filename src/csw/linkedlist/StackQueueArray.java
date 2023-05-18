package linkedlist;

class Stack extends BaseStack {
    int top = -1;
    int[] stack;

    Stack(int max_length) {
        super(max_length);
        stack = new int[max_length];
    }

    public void push(int data) {
        if (top < (MAX_LENGTH - 1))
            stack[++top] = data;
        else
            System.out.println("StackOverflow: Max length of stack exceeded.");
    }

    public void pop() {
        if (top == -1)
            System.out.println("Underflow, stack is empty");
        else
            System.out.println("Element removed = " + stack[top--]);
    }

    public void displayStack() {
        for (int i = top; i >= 0; i--) {
            if (i == top)
                System.out.printf("| %-5s | -> TOP%n", stack[i]);
            else
                System.out.printf("| %-5s |%n", stack[i]);
        }
    }

    @Override
    void peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }
}

public class StackQueueArray {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.menu();
    }
}
