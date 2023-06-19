package ASSIGNMENT4;

import java.util.Arrays;

public class Q14 {
  public static int MinDiffPair(int arr1[], int size1, int arr2[], int size2) {
    int minDiff = 9999999;
    int first = 0;
    int second = 0;
    int out1 = 0, out2 = 0, diff;
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    while (first < size1 && second < size2) {
      diff = Math.abs(arr1[first] - arr2[second]);
      if (minDiff > diff) {
        minDiff = diff;
        out1 = arr1[first];
        out2 = arr2[second];
      }
      if (arr1[first] < arr2[second])
        first += 1;
      else
        second += 1;
    }
    System.out.println("The pair is :: " + out1 + out2);
    System.out.println("Minimum difference is :: " + minDiff);
    return minDiff;
  }

}
