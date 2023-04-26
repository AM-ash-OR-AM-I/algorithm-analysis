package arrays;

import utils.Util;

public class FindMaximaBitonic {
    static int findMaxima(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == -1) {
                return 0;
            }
            if (mid == n) {
                return n - 1;
            }
            int x = arr[mid];
            if (x > arr[mid - 1] && x > arr[mid + 1]) {
                return mid;
            } else if (x > arr[mid - 1] && x < arr[mid + 1]) {
                low = mid + 1;
            } else if (x > arr[mid + 1] && x < arr[mid - 1]) {
                high = mid - 1;
            } else {
                break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int index = findMaxima(arr);
        System.out.printf("Maxima found at index %d", index);
    }
}
