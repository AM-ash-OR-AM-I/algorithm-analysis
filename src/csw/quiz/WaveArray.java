package quiz;
import utils.Util;

public class WaveArray {
    static void makeWaveArray(int[] arr) {
        /*
         * Convert the array in such a way that odd indexed elements are less than its
         * neighbouring elements.
         */
        int n = arr.length;
        for (int i = 1; i < n; i += 2) {
            if (i == n - 1) {
                // If the last index is odd
                if (arr[i - 1] < arr[i]) {
                    Util.swap(arr, i, i - 1);
                }
            } else if (arr[i - 1] < arr[i] && arr[i - 1] < arr[i + 1]) {
                Util.swap(arr, i, i - 1);
            } else if (arr[i + 1] < arr[i] && arr[i + 1] < arr[i - 1]) {
                Util.swap(arr, i, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        makeWaveArray(arr);
        Util.display(arr, "Wave Array: ");
    }
}
