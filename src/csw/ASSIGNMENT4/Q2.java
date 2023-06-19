package ASSIGNMENT4;

import java.util.HashSet;

public class Q2 {
  static void printDuplicates(int[] arr) {
    HashSet<Integer> hashSet = new HashSet<>();
    for (int x : arr) {
      if (hashSet.contains(x)) {
        System.out.println(x + " is duplicate.");
      } else {
        hashSet.add(x);
      }
    }
  }
}
