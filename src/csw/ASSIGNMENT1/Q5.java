package ASSIGNMENT1;

import java.util.Arrays;
import java.util.Scanner;

import utils.Util;

// Q5: Rotate Element k number of times

public class Q5 {
    static void rotateKtimes(int[] arr, int k) {
        /*
         * [2, 4, 7, 5, 9]
         * k = 2 to right
         * After 2 rotations = [7, 5, 9, 2, 4]
         */
        int n = arr.length;
        k = k % n;
        int rest = n - k;
        int[] subArr2 = new int[k];
        for (int i = 0; i < k; i++) {
            subArr2[i] = arr[i];
        }
        for (int i = 0; i < rest; i++) {
            arr[i] = arr[i + k];
        }
        for (int i = 0; i < k; i++) {
            arr[rest + i] = subArr2[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        rotateKtimes(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
