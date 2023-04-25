package arrays;

import java.util.Arrays;
import java.util.HashSet;

import utils.Util;

public class PairSumClosestToN {
    static void findPairClosestToN(int[] arr, int ref) {
        /*
         * O(N^2)
         */
        int leastDiff = Integer.MAX_VALUE;
        int x = arr[0], y = arr[1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int currentSum = arr[i] + arr[j];
                int diff = Math.abs(ref - currentSum);
                if (diff < leastDiff) {
                    leastDiff = diff;
                    x = arr[i];
                    y = arr[j];
                }
            }
        }
        System.out.printf("Closest pair to %d, is %d and %d", ref, x, y);
    }

    static void findPairClosestToZero(int[] arr) {
        /*
         * O(nlogn)
         */
        Arrays.sort(arr);
        int minSum = arr[0] + arr[1];
        int minX = arr[0], minY = arr[arr.length - 1];
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < minSum) {
                minX = arr[i];
                minY = arr[j];
                minSum = sum;
            }
            if (sum > 0)
                j--;
            else
                i++;
        }

        System.out.printf("Closest pair to Zero, is %d and %d", minX, minY);
    }

    static boolean findDiffEqualToN(int[] arr, int ref) {
        /*
         * O(N) use HashSet
         */
        HashSet<Integer> hashSet = new HashSet<>();
        for (int x : arr) {
            hashSet.add(x);
        }

        for (int x : arr) {
            int otherPair = Math.abs(ref - x);
            if (hashSet.contains(otherPair)) {
                System.out.printf("Two pair are %d and %d%n", x, otherPair);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        boolean found = findDiffEqualToN(arr, 15);
        if (!found) {
            System.out.println("No pair found");
        }
        findPairClosestToZero(arr);
    }
}
