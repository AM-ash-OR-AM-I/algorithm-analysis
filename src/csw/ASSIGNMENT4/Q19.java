package ASSIGNMENT4;

import java.util.Arrays;

public class Q19 {
  public static int getMedian(int[] arr, int size) {
    Arrays.sort(arr);
    return arr[size / 2];
  }
}
