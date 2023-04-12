package sorting;

import java.util.Stack;

import utils.Util;

public class DoublePivotPartion {
    static void doublePivotPartion(int[] arr, int lowerRange, int upperRange) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        for (int x : arr) {
            if (x < lowerRange) {
                stack1.add(x);
            } else if (x < upperRange && x > lowerRange) {
                stack2.add(x);
            } else {
                stack3.add(x);
            }
        }
        stack3.addAll(stack2);
        stack3.addAll(stack1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack3.pop();
        }
    }

    static void rangePartition(int[] arr, int lowerRange, int upperRange) {
        int start = 0;
        int size = arr.length;
        int end = size - 1;
        int i = 0;
        while (i <= end) {
            if (arr[i] < lowerRange) {
                Util.swap(arr, start++, i++);
            } else if (arr[i] > upperRange) {
                Util.swap(arr, end--, i);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 10, 14, 2, 4, 20, 1, 7 };
        int lowerRange = 3, upperRange = 8;
        doublePivotPartion(arr, lowerRange, upperRange);
        Util.display(arr, String.format("Partioned by %d and %d using Stack:%n", 3, 8));
        rangePartition(arr, lowerRange, upperRange);
        Util.display(arr, String.format("Partioned by %d and %d using swap:%n", 3, 8));

    }
}
