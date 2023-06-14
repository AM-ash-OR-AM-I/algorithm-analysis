package practice;

import java.util.Stack;

import utils.Util;

public class FindNearestSmallest {
    static void findNearestSmallest(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    System.out.print(arr[j] + ", ");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.print("-1, ");
            }
        }
    }

    static void findNearestSmallestBest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (element < stack.peek()) {
                stack.pop();
            }
            stack.push(element);
        }
    }

    public static void main(String[] args) {
        // {10, 6, 12, 7, 9}
        // -1 -1 6 6 7
        int[] arr = Util.takeUserInput();
        findNearestSmallest(arr);

    }
}
