package ASSIGNMENT3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import utils.Util;

public class Q5 {
  static void sort1stArray2ndArray(int[] arr1, int[] arr2) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    HashSet<Integer> hashArr2 = new HashSet<>();
    ArrayList<Integer> auxArrayList = new ArrayList<>();
    for (int x : arr2) {
      hashArr2.add(x);
    }
    for (int x : arr1) {
      if (!hashArr2.contains(x)) {
        auxArrayList.add(x);
      }
      if (hashMap.containsKey(x)) {
        int count = hashMap.get(x);
        hashMap.put(x, count + 1);
      } else {
        hashMap.put(x, 1);
      }
    }
    int index = 0;
    for (int x : arr2) {
      int count = hashMap.get(x);
      while (count-- > 0) {
        arr1[index++] = x;
      }
    }

    for (int x : auxArrayList) {
      arr1[index++] = x;
    }
  }

  public static void main(String[] args) {
    int[] arr1 = Util.takeUserInput();
    int[] arr2 = Util.takeUserInput();
    sort1stArray2ndArray(arr1, arr2);
    Util.display(arr1, "Array2 sorted according to array1: ");

  }
}
