package ASSIGNMENT3;

public class Q8 {
  public static void merge(int[] arr1, int size1, int[] arr2, int size2) {
    int index = 0;
    while (index < size1) {
      if (arr1[index] <= arr2[0]) {
        index += 1;
      } else {
        // always first element of arr2 is compared.
        arr1[index] ^= arr2[0] ^= arr1[index] ^= arr2[0];
        index += 1;
        // After swap arr2 may be unsorted.
        // Insertion of the element in proper sorted position.
        for (int i = 0; i < (size2 - 1); i++) {
          if (arr2[i] < arr2[i + 1])
            break;
          arr2[i] ^= arr2[i + 1] ^= arr2[i] ^= arr2[i + 1];
        }
      }
    }
  }

  // Testing code.
  public static void main(String[] args) {
    int arr1[] = { 1, 5, 9, 10, 15, 20 };
    int arr2[] = { 2, 3, 8, 13 };
    merge(arr1, arr1.length, arr2, arr2.length);
  }
}
