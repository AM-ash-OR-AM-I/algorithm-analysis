package quiz;

import java.util.Scanner;
import java.util.Stack;

public class MyStack {
    static Scanner sc = new Scanner(System.in);

    static int getInput() {
        System.out.println("""
                Enter your choice:
                1. Push
                2. Pop
                Press any other key to exit.
                """);
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int choice = getInput();
        while (choice == 1 || choice == 2) {
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to push: ");
                    int element = sc.nextInt();
                    stack.push(element);
                    System.out.printf("Stack currently: %s%n%n", stack);
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty, underflow");
                    } else {
                        int removed = stack.pop();
                        System.out.println(removed + " is popped. Current stack : " + stack);
                    }
                    break;
            }
            choice = getInput();

        }

    }
}
