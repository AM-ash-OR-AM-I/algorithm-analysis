package sorting;

import utils.Util;

public class SelectionSort {
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            Util.swap(arr, i, minPos);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4324, 78, 5435, 354, 1, 324, 34 };
        selectionSort(arr);
        Util.display(arr, "Selection sort array: ");
    }
}
