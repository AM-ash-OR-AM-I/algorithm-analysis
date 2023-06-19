package ASSIGNMENT4;

import utils.Util;

public class Q7 {
  static int oddCount(int[] arr) {
    int xorSum = 0;
    for (int x : arr) {
      xorSum ^= x;
    }
    return xorSum;
  }

  public static void main(String[] args) {
    int[] arr = Util.takeUserInput();
    int odd = oddCount(arr);
    System.out.println(odd + " appears odd number times");
  }
}
