package sorting;

import utils.Util;

public class InsertionSort {
    static void insertionSort(int[] arr) {
        /*
         * TODO: add it to gist: `Editor: Mouse Wheel Zoom`
         * TODO: add language specific indentation 
         * T(n):
         * O(N^2): worst case
         * O(N) : best case (sorted)
         * 
         * It is stable sort.
         */
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > element) {
                arr[j + 1] = arr[j]; // Shift
                j--;
            }
            arr[j + 1] = element;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5345, 435, 656, 453 };
        insertionSort(arr);
        Util.display(arr, "Array after sorting: ");
    }
}
