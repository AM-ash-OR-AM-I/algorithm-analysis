package ASSIGNMENT1;
/*
 * Given a sorted array, rearrange it in maximum-minimum form.
 */

import java.util.Arrays;

import utils.Util;

public class Q10 {
    static void maximumMinimum(int[] arr) {
        /*
         * {1, 2, 3, 4, 5, 6, 7}
         * {7, 1, 6, 2, 5, 3, 4}
         * Maximum - minimum
         */
        int[] copiedArr = Arrays.copyOf(arr, arr.length);
        int i = 0;
        for (int first = 0, last = arr.length - 1; first <= last; first++, last--) {
            if (first != last)
                arr[i + 1] = copiedArr[first];
            arr[i] = copiedArr[last];
            i += 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        maximumMinimum(arr);
        Util.display(arr, "Maximum-Minimum arr:");
    }
}

/*
 * O/P:
 * ----
 * 1 2 3 4 5 6 7
 * 7 1 6 2 5 3 4
 * 
 * T(n) = O(N)
 */