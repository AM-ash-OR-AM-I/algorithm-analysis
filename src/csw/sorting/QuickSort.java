package sorting;

import utils.Util;

public class QuickSort {
    static int find_pivot_index(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (arr[j] < pivot) {
                Util.swap(arr, ++i, j);
            }
        }
        Util.swap(arr, ++i, pivot);
        return i;
    }

    static void quickSort(int[] arr, int begin, int end) {
        int pivot = find_pivot_index(arr, begin, end);
        quickSort(arr, pivot + 1, end);
        quickSort(arr, begin, pivot - 1);
    }

    static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 4234, 23453, 45 };
        sort(arr);
        Util.display(arr, "Array after soting: ");
    }
}
