package stack;

import utils.Util;

public class StockSpanProblem {
    static int stockSpanRange(int[] arr) {
        /*
         * O(N^2)
         */
        int maxSpan = 1;
        for (int i = 0; i < arr.length; i++) {
            int currentStock = arr[i];
            for (int j = 0; j < i; j++) {
                if (currentStock > arr[j]) {
                    maxSpan = (i - j) + 1;
                    break;
                }
            }
        }
        return maxSpan;
    }

    static int stockSpanRangeOptimized(int[] arr){

    }
    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int maxSpan = stockSpanRange(arr);
        System.out.println(maxSpan);
    }
}
