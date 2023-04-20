package arrays;

import utils.Util;

public class MaxMinValue {
    // O(N)
    static void findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > max)
                max = x;
            if (x < min)
                min = x;
        }
        System.out.println("Max = " + max + ", Min = " + min);
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        findMinMax(arr);
    }
}
