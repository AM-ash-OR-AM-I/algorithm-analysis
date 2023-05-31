package stack;

import java.util.Arrays;
import java.util.Stack;

import utils.Util;

public class StockSpanProblem {
    static int[] stockSpanRange(int[] arr) {
        /*
         * O(N^2)
         */
        int[] SR = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int currentStock = arr[i];
            SR[i] = 1;
            for (int j = 0; j < i; j++) {
                if (currentStock > arr[j]) {
                    SR[i] = (i - j) + 1;
                    break;
                }
            }
        }
        return SR;
    }

    static int[] stockSpanRangeOptimized(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] SR = new int[arr.length];
        stack.push(0);
        SR[0] = 1;
        for (int i = 1; i < SR.length; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            SR[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return SR;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int[] maxSpan = stockSpanRangeOptimized(arr);
        System.out.println(Arrays.toString(maxSpan));
    }
}
