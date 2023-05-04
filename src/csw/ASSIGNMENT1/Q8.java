package ASSIGNMENT1;

import java.util.Arrays;

import utils.Util;

/*
 * Given an array of size N, containing elements from 0 to N-1. All values
from 0 to N-1 are present in array and if they are not there than -1 is
there to take place. Write a program to arrange values of the array so
that value i is stored at arr[i].
 */

public class Q8 {
    static void indexArray(int[] arr) {
        /*
         * [2, -1, 0, 4, -1]
         * T(n) = O(N)
         */
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != -1 && arr[i] != i) {
                Util.swap(arr, i, arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        indexArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
