package sorting;

import java.util.Arrays;

import utils.Util;

/*
 * Problem 5.38: Given an array find if there is a pair whose sum is equal to the sum of
 * rest of the elements of the array.
 */
public class SumPairEqualRest {
    static boolean sumPairEqualRest(int[] arr, int size) {
        Arrays.sort(arr); // Sorts the array
        int totalSum = 0; // Calculate total sum
        for (int x : arr) {
            totalSum += x;
        }

        // If both sum of pair and rest of them is same then sum is half.
        int half = totalSum / 2;

        // Take 2 pointers low and high
        int low = 0;
        int high = size - 1;

        int currentSum;
        while (low < high) {
            currentSum = arr[low] + arr[high]; // Sum of a pair

            // If currentSum is less than sum/2, low++, currentSum of pair increases.
            if (currentSum < half)
                low++;

            // If currentSum is greater than sum/2, high++, currentSum of pair decreases.
            else if (currentSum > half)
                high--;

            // currentSum = sum of rest of them
            else {

                System.out.println("Pair is: " + currentSum);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        boolean found = sumPairEqualRest(arr, arr.length);
        if (!found) {
            System.out.println("No such pair found");
        }

    }
}
