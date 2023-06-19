package ASSIGNMENT3;

import utils.Util;

public class Q6 {
  static void separateOddEven(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 == 0) {
        Util.swap(arr, i, right--);
      } else {
        Util.swap(arr, i, left++);
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = Util.takeUserInput();
    separateOddEven(arr);
    Util.display(arr, "Odd even separated array: ");
  }
}
