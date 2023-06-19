package ASSIGNMENT4;

public class Q20 {
  public static int SearchBitonicArray(int[] arr, int size, int key) {
    int max = FindMaxBitonicArray(arr, size);
    int k = BinarySearch(arr, 0, max, key, true);
    if (k != -1) {
      return k;
    } else {
      return BinarySearch(arr, max + 1, size - 1, key, false);
    }
  }

  public static int FindMaxBitonicArray(int[] arr, int size) {
    int start = 0, end = size - 1, mid;
    if (size < 3) {
      System.out.println("error");
      return -1;
    }
    while (start <= end) {
      mid = (start + end) / 2;
      if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid])// maxima
      {
        return mid;
      } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1])// increasing
      {
        start = mid + 1;
      } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1])// increasing
      {
        end = mid - 1;
      } else {
        break;
      }
    }
    System.out.println("error");
    return -1;
  }
}
