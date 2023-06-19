package ASSIGNMENT4;

import java.util.HashSet;

public class Q1 {
  static int findFirst(int[] arr) {
    HashSet<Integer> hashSet = new HashSet<>();
    for (int x : arr) {
      if (hashSet.contains(x)) {
        return x;
      }
      hashSet.add(x);
    }
    return -1;
  }
}
