package ASSIGNMENT1;

import java.util.Arrays;

import utils.Util;

/*
 * Q11:
 * Given an array you need to find the maximum sum of arr[i]*(i+1) for
 * all elements such that you are allowed to rotate the array.
 */

public class Q11 {
    static int maxSum(int[] arr) {
        int n = arr.length;
        int maximumSum = 0, sum = 0;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            currentSum += arr[i] * (i + 1);
        }
        for (int i = 0; i < (n - 1); i++) {
            /* 
             * n*arr[i] => each element is placed at last index, and that means all other elements index are decreased by 1
             * e.g. [5, 1, 2, 3, 4]
             *         /  /  /  /
             *      [1, 2, 3, 4, 5] difference = 5*(length = 5) - (1+2+3+4+5 = sum)
             * diff = arr[i]*n - sum
             */
            int diff = arr[i] * n - sum;
            currentSum += diff;
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int sum = maxSum(arr);
        System.out.println("Maxsum = " + sum);
    }
}
