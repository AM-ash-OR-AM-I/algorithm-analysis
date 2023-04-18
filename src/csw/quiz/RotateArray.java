package quiz;

import java.util.Scanner;

import utils.Util;

public class RotateArray {
    static void rotateArray(int[] arr, int k) {
        // Initialising subArray to store the first k elements.
        int[] rightSubArray = new int[k];
        int n = arr.length;
        /*
         * Using mod k%n makes sure if no. of rotations is greater than length
         * like k = 15, n=10, rotating it by 5 places have same effect.
         */
        k = k % n;
        int rest = arr.length - k;
        for (int i = 0; i < k; i++) {
            rightSubArray[i] = arr[i];
        }

        // Shifting the rest of rthe elements k places to the left.
        for (int i = 0; i < rest; i++) {
            arr[i] = arr[i + k];
        }

        // adding the rightSubarray containg the first k elements
        for (int i = 0; i < k; i++) {
            arr[rest + i] = rightSubArray[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();

        System.out.print("Enter no. of rotations: ");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        rotateArray(arr, k);
        Util.display(arr, "Array after rotation: ");

        /**
         * Time complexity = O(N)
         */

    }
}
