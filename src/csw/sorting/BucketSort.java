package sorting;

import utils.Util;

public class BucketSort {
    static void bucketSort(int[] arr, int lowerRange, int upperRange) {
        // T(n) = O(n)
        int n = upperRange - lowerRange;
        int[] countArr = new int[n];
        for (int x : arr) {
            countArr[x]++;
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            int x = countArr[i];
            while (x-- != 0) {
                arr[index++] = i;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 0, 1, 2, 2, 1 };
        int lowerRange = 0;
        int upperRange = 3;
        bucketSort(arr, lowerRange, upperRange);
        Util.display(arr, "Bucket sort: ");
    }
}
