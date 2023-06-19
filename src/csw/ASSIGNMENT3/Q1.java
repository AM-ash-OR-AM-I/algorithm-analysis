package ASSIGNMENT3;

import java.util.Arrays;

import utils.Util;

// Sort Array in Zeroes and ones.
public class Q1 {

  static void partition01(int[] arr) {
    int size = arr.length;
    int left = 0;
    int right = size - 1;
    while (left < right) {
      while (arr[left] == 0)
        left++;
      while (arr[right] == 1)
        right--;

      if (left < right) {
        Util.swap(arr, left, right);
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = Util.takeUserInput();
    partition01(arr);
    System.out.println(Arrays.toString(arr));
  }
}

/*
 * OP:
 * Enter the array elements seprated by spaces:
 * 0 1 1 0 1 1 0
 * [0, 0, 0, 1, 1, 1, 1]
 */