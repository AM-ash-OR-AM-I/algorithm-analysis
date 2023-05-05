package ASSIGNMENT1;

import utils.Util;

// Q6: Given array of +ve and -ve integers find contiguous sub array having max sum.
public class Q6 {
    static int findMaxSum(int[] arr) {
        /*
         * Bruteforce with sum store: O(N^2)
         */
        int maxSum = 0, currentSum = 0;
        int n = arr.length;
        int[] sumArr = new int[n];
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            sumArr[i] = currentSum;
        }
        Util.display(sumArr, "sumArr");
        for (int k = 1; k < n; k++) {
            currentSum = 0;
            for (int j = 0; j < (n - k); j++) {
                currentSum = (sumArr[j + k] - sumArr[j] + arr[j]);
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int maxSum = findMaxSum(arr);
        System.out.println("Max sum = " + maxSum);
    }
}
