package ASSIGNMENT4;

import java.util.HashSet;

public class Q4 {
  static void removeDuplicates(int[] arr) {
    HashSet<Integer> hashSet = new HashSet<>();
    for (int x : arr) {
      if (hashSet.contains(x)) {
        hashSet.remove(x);
      }
    }
  }
}
