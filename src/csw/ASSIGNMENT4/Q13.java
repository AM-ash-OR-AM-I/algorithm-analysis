package ASSIGNMENT4;

import java.util.Arrays;

public class Q13 {
  public static int findMinDiff(int[] arr, int size) {
    Arrays.sort(arr);
    int diff = 9999999;
    for (int i = 0; i < (size - 1); i++) {
      if ((arr[i + 1] - arr[i]) < diff)
        diff = arr[i + 1] - arr[i];
    }
    return diff;
  }
}
