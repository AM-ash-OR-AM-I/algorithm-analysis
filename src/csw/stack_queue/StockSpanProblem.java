package stack_queue;

import java.util.Arrays;
import java.util.Stack;

import utils.Util;

public class StockSpanProblem {
    static int[] stockSpanRange(int[] arr) {
        /*
         * O(N^2)
         */
        int[] stockRangeArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int currentStock = arr[i];
            stockRangeArr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (currentStock > arr[j]) {
                    stockRangeArr[i] = (i - j) + 1;
                    break;
                }
            }
        }
        return stockRangeArr;
    }

    static int[] stockSpanRangeOptimized(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] stockRangeArr = new int[arr.length];
        stack.push(0);
        stockRangeArr[0] = 1;
        int operations = 0;
        for (int i = 1; i < stockRangeArr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                // Keep popping elements untill you reach the element that is bigger than
                // current value.
                stack.pop();
                operations++;
                System.out.println("Stack after pop" + stack);
            }

            // Difference between current element and the nearest element bigger than
            // current. If no element is there in stack => the current element is maximum
            // so, i+1 indicates
            // the maximum element till ith iteration.
            stockRangeArr[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push the element that is added
            stack.push(i);
            operations++;
            System.out.println("stack after push" + stack);
        }
        System.out.println("Total no. of ops = " + operations);
        return stockRangeArr;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int[] maxSpan = stockSpanRangeOptimized(arr);
        System.out.println(Arrays.toString(maxSpan));
    }
}
