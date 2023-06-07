package misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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

    static int[] findMaxSlidingWindowOptimized(int[] arr, int k) {
        // TODO: Implement optimized using queue by removing elements from queue when
        // sliding
        int n = arr.length;
        int[] slidingWindows = new int[n - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>(3);
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            queue.add(arr[i]);
            // System.out.println(queue);
            System.out.println(queue.peekLast());
        }

        return slidingWindows;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int[] slidingWindows = findMaxSlidingWindowOptimized(arr, 3);
        System.out.println(Arrays.toString(slidingWindows));
    }
}
