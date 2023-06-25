package stack_queue;

import utils.Util;

public class GetMaxArea {
    static int findMinHeight(int[] arr, int i, int j) {
        int minHeight = arr[i];
        while (i <= j) {
            if (arr[i] < minHeight) {
                minHeight = arr[i];
            }
            i++;
        }
        return minHeight;
    }

    static int getMaxArea(int[] arr) {
        /*
         * Bruteforce: O(N^2)
         */
        int maxArea = 0, minHeight = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                minHeight = findMinHeight(arr, j, j + n - i - 1);
            }
            maxArea = Math.max(maxArea, minHeight * (n - i));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int maxArea = getMaxArea(arr);
        System.out.println(maxArea);
    }
}
