package ASSIGNMENT4;

import java.util.HashSet;

public class Q6 {
  public static void MissingValues2(int[] arr, int size) {
    HashSet<Integer> ht = new HashSet<Integer>();
    int minVal = 999999;
    int maxVal = -999999;
    for (int i = 0; i < size; i++) {
      ht.add(arr[i]);
      if (minVal > arr[i])
        minVal = arr[i];
      if (maxVal < arr[i])
        maxVal = arr[i];
    }
    for (int i = minVal; i < maxVal + 1; i++) {
      if (ht.contains(i) == false) {
        System.out.println(i);
      }
    }
  }
}
