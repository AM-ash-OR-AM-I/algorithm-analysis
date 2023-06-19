package ASSIGNMENT3;
// In given integer list that support three functions findMin, findMax, findMedian. Sort the array.

public class Q10 {
  public static int findMin(int[] arr) {
    int min = arr[0];
    for (int x : arr) {
      min = Math.min(x, min);
    }
    return min;
  }

  public static int findMax(int[] arr) {
    int max = arr[0];
    for (int x : arr) {
      max = Math.max(x, max);
    }
    return max;
  }

  public static int findMedian(int[] arr) {
    return arr[(int) Math.ceil(arr.length / 2)];
  }

  public static void main(String[] args) {
    int[] arr = { 32, 4234, 32434, 32423, 67 };
    findMax(arr);
    findMin(arr);
    findMedian(arr);
  }
}
