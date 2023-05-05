package ASSIGNMENT2A;
/*
 * Write a java program to evaluate a postfix expression using Stack
 */

import java.util.Stack;

public class Q4 {
    static int evaluatePostfix(String expression) {
        char[] expressionArr = expression.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char character : expressionArr) {
            if (character >= '0' && character <= '9') {
                int digit = (int) (character - '0');
                stack.push(digit);
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                switch (character) {
                    case '*' -> stack.push(operand2 * operand1);
                    case '+' -> stack.push(operand2 + operand1);
                    case '-' -> stack.push(operand2 - operand1);
                    case '/' -> stack.push(operand2 / operand1);
                    case '^' -> stack.push((int) Math.pow(operand2, operand1));
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        // Only works for single digit number, O(N) time complexity
        String expString = "23*45+*";
        int result = evaluatePostfix(expString);
        System.out.println("Result = " + result);
    }
}
