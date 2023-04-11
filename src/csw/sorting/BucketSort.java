package sorting;

import utils.Util;

public class BucketSort {
    static void bucketSort(int[] arr, int lowerRange, int upperRange) {
        int n = upperRange - lowerRange;
        int[] countArr = new int[n];
        for (int x : arr) {
            countArr[x]++;
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            int x = countArr[i];
            while (x-- != 0) {
                arr[index++] = i + lowerRange;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { -5, 342, 35, 45, 432, 234, 234 };
        int lowerRange = -10;
        int upperRange = 500;
        bucketSort(arr, lowerRange, upperRange);
        Util.display(arr, "Bucket sort: ");
    }
}
