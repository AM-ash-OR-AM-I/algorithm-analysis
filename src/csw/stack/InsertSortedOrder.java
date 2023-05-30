package stack;

import java.util.Stack;

public class InsertSortedOrder {
    /**
     * Inserts element in sorted order.
     * When stack is popped it stores the element in a variable
     * then push element after new element is inserted
     * 
     * @param stack
     * @param insertElement
     */
    static void insertSorted(Stack<Integer> stack, int insertElement) {
        if (!stack.isEmpty() && stack.peek() > insertElement) { // If top > insertElement
            int removed = stack.pop();
            insertSorted(stack, insertElement);
            stack.push(removed);
        } else {
            stack.push(insertElement);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(235);
        stack.push(324);
        stack.push(535);
        insertSorted(stack, 5435);
        System.out.println(stack);
    }
}
