package misc;

import java.util.ArrayDeque;
import java.util.Arrays;

import utils.Util;

public class MaximumSliding {
    static int[] findMaxSlidingWindow(int[] arr, int k) {
        /*
         * Bruteforce:
         * -----------
         * O(n*k)
         */
        int n = arr.length;
        int[] slidingWindows = new int[n - k + 1];
        int max;
        for (int i = 0; i < n - k + 1; i++) {
            max = arr[i];
            for (int j = 1; j < k; j++) {
                max = Math.max(max, arr[i + j]);
            }
            slidingWindows[i] = max;
        }
        return slidingWindows;
    }

    /**
     * Maximum value in a sliding window, check out, csw\misc\sliding_window.jpg
     */
    static int[] findMaxSlidingWindowOptimized(int[] arr, int k) {
        int n = arr.length;
        int[] slidingWindows = new int[n - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>(3);

        for (int i = 0; i < arr.length; i++) {
            // If element to be inserted is greater than than previously inserted elements.
            while (!queue.isEmpty() && arr[i] <= arr[queue.peekLast()]) {
                queue.removeLast();
            }

            // If element to be inserted is out of range.
            if (!queue.isEmpty() && queue.peekFirst() <= (i - k)) {
                queue.removeFirst();
            }

            // Push the new element to end of the queue.
            queue.add(i);

            // Start printing only after k elements are scanned.
            if (i >= (k - 1)) {
                slidingWindows[i - k + 1] = arr[queue.peekFirst()];
            }

        }

        return slidingWindows;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int[] slidingWindows = findMaxSlidingWindowOptimized(arr, 3);
        System.out.println(Arrays.toString(slidingWindows));
    }
}
