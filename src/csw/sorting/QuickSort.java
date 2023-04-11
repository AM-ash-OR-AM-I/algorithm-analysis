package sorting;

public class QuickSort {
    static int pivot(int arr, int begin, int end) {
        // int pivot = arr[end];

        return 1;
    }

    static void quickSort(int[] arr, int begin, int end) {
        int pivot = pivot(end, begin, end);
        quickSort(arr, pivot + 1, end);
        quickSort(arr, begin, pivot - 1);
    }

    static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 4234, 23453, 45 };
        sort(arr);
    }
}
