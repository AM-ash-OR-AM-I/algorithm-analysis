package ASSIGNMENT1;

import utils.Util;

/*
 * Q12:
 * Given an array arr[], find maximum distance of index j and i, such
 * that arr[j] > arr[i]
 */

public class Q12 {
    static int maxDistIJ(int[] arr) {
        /*
         * T(n) = O(N^2) Brute force
         * Can be optimised further to O(N)
         */
        int dist = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    dist = Math.max(dist, j - i);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int maxDist = maxDistIJ(arr);
        System.out.println("Max distance = " + maxDist);
    }
}
