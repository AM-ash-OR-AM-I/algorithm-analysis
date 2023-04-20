package sorting;

import java.util.Arrays;

import utils.Util;

public class MergeArrayConstantSpace {
    static void mergeNoExtraSpace(int[] arr1, int[] arr2) {
        // TODO: understand this code.

        int n = arr1.length, m = arr2.length;
        // Iterate through all elements of ar2[] starting
        // from the last element
        for (int i = n - 1; i >= 0; i--) {
            /*
             * Find the smallest element greater than
             * ar2[i]. Move all elements one position ahead
             * till the smallest greater element is not
             * found
             */
            int j, last = arr1[m - 1];
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j + 1] = arr1[j];

            // If there was a greater element
            if (last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr1 = Util.takeUserInput();
        int[] arr2 = Util.takeUserInput();
        mergeNoExtraSpace(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
