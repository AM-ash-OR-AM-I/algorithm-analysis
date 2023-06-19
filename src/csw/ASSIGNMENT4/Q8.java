package ASSIGNMENT4;

public class Q8 {
  public static void OddCount2(int[] arr, int size) {
    int xorSum = 0;
    int first = 0;
    int second = 0;
    int setBit;
    /*
     * xor of all elements in arr[] even occurrence will cancel each other.
     * sum will contain sum of two odd elements.
     */
    for (int i = 0; i < size; i++)
      xorSum = xorSum ^ arr[i];
    /* Rightmost set bit. */
    setBit = xorSum & ~(xorSum - 1);
    /*
     * Dividing elements in two group: Elements having setBit bit as 1. Elements
     * having setBit bit as 0. Even elements cancelled themselves if group and we
     * get our numbers.
     */
    for (int i = 0; i < size; i++) {
      if ((arr[i] & setBit) != 0)
        first ^= arr[i];
      else
        second ^= arr[i];
    }
    System.out.println(first + second);
  }
}
