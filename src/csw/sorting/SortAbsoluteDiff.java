package sorting;

import utils.Util;

public class SortAbsoluteDiff {
    static void sortAbsDiff(int[] arr, int ref) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[j] - ref) < Math.abs(arr[i] - ref)) {
                    Util.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3242, 325, 234, 34, 1, 232423 };
        sortAbsDiff(arr, 300);
        Util.display(arr, "Sorted in Ascending order: ");
    }
}
