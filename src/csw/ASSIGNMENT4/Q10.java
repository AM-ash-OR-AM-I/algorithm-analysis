package ASSIGNMENT4;

public class Q10 {
  public static void minAbsSumPair(int[] arr, int size) {
    int l, r, minSum, sum, minFirst, minSecond;
    // Array should have at least two elements
    if (size < 2) {
      System.out.println("Invalid Input");
      return;
    }
    // Initialization of values
    minFirst = 0;
    minSecond = 1;
    minSum = Math.abs(arr[0] + arr[1]);
    for (l = 0; l < size - 1; l++) {
      for (r = l + 1; r < size; r++) {
        sum = Math.abs(arr[l] + arr[r]);
        if (sum < minSum) {
          minSum = sum;
          minFirst = l;
          minSecond = r;
        }
      }
    }
    System.out.println(" Minimum sum elements are : " + arr[minFirst] + " , " +
        arr[minSecond]);
  }
}
