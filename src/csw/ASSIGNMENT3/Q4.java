package ASSIGNMENT3;

import java.util.Arrays;

import utils.Util;

public class Q4 {
  static int findMinSwapToPivotElements(int[] arr, int val) {
    int swaps = 0;
    int low = 0, high = arr.length - 1;
    while (low < high) {
      if (arr[low] <= val) {
        low++;
      } else if (arr[high] > val) {
        high--;
      } else {
        Util.swap(arr, high, low);
        swaps++;
      }
    }
    return swaps;
  }

  public static void main(String[] args) {
    int[] arr = Util.takeUserInput();
    findMinSwapToPivotElements(arr, 10);
    System.out.println(Arrays.toString(arr));
  }
}
