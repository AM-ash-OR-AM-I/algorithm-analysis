package ASSIGNMENT3;

import java.util.Arrays;

import utils.Util;

public class Q2 {
  static void partition012(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    int i = 0;
    while (i <= right) {
      if (arr[i] == 0) {
        Util.swap(arr, i, left);
        i += 1;
        left += 1;
      } else if (arr[i] == 2) {
        Util.swap(arr, i, right);
        right -= 1;
      } else {
        i += 1;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = Util.takeUserInput();
    partition012(arr);
    System.out.println(Arrays.toString(arr));
  }
}

/*
 * OP:
 * Enter the array elements seprated by spaces:
 * 0 1 1 2 0 2 1 0 0 2
 * [0, 0, 0, 0, 1, 1, 1, 2, 2, 2]
 */