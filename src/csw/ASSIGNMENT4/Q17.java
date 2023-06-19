package ASSIGNMENT4;

public class Q17 {
  public static int numberOfTriangles(int[] arr, int size) {
    int i, j, k, count = 0;
    for (i = 0; i < (size - 2); i++) {
      for (j = i + 1; j < (size - 1); j++) {
        for (k = j + 1; k < size; k++) {
          if (arr[i] + arr[j] > arr[k])
            count += 1;
        }
      }
    }
    return count;
  }
}
