package ASSIGNMENT3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Q9 {
  public static void UnionIntersectionSorted(int arr1[], int size1, int arr2[], int size2) {
    int first = 0, second = 0;
    int[] unionArr = new int[size1 + size2];
    int[] interArr = new int[Math.min(size1, size2)];
    int uIndex = 0;
    int iIndex = 0;
    while (first < size1 && second < size2) {
      if (arr1[first] == arr2[second]) {
        unionArr[uIndex++] = arr1[first];
        interArr[iIndex++] = arr1[first];
        first += 1;
        second += 1;
      } else if (arr1[first] < arr2[second]) {
        unionArr[uIndex++] = arr1[first];
        first += 1;
      } else {
        unionArr[uIndex++] = arr2[second];
        second += 1;
      }
    }
    while (first < size1) {
      unionArr[uIndex++] = arr1[first];
      first += 1;
    }
    while (second < size2) {
      unionArr[uIndex++] = arr2[second];
      second += 1;
    }
    System.out.println(Arrays.toString(unionArr));
    System.out.println(Arrays.toString(interArr));
  }

  public static void UnionIntersectionUnsorted(int arr1[], int size1, int arr2[], int size2) {
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    UnionIntersectionSorted(arr1, size1, arr2, size2);
  }

  public static HashSet<Integer> intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
    HashSet<Integer> intersection = new HashSet<>();
    Iterator<Integer> iterator1 = set1.iterator();
    while (iterator1.hasNext()) {
      int element = iterator1.next();
      if (set2.contains(element)) {
        intersection.add(element);
      }
    }
    return intersection;
  }

  public static void union(HashSet<Integer> set1, HashSet<Integer> set2) {
    set1.addAll(set2);
  }

  public static void UnionIntersectionUnsortedSet(int arr1[], int size1, int arr2[], int size2) {
    HashSet<Integer> set1 = new HashSet<>(size1);
    HashSet<Integer> set2 = new HashSet<>(size1);
    for (int x : arr1) {
      set1.add(x);
    }
    for (int x : arr2) {
      set2.add(x);
    }

    HashSet<Integer> intersection = intersection(set1, set2);
    union(set1, set2);
    System.out.println(intersection)  ;
    System.out.println(set1);
  }

  public static void main(String[] args) {
    int arr1[] = { 1, 11, 2, 3, 14, 5, 6, 8, 9 };
    int arr2[] = { 2, 4, 5, 12, 7, 8, 13, 10 };
    UnionIntersectionUnsortedSet(arr1, arr1.length, arr2, arr2.length);
    UnionIntersectionUnsorted(arr1, arr1.length, arr2, arr2.length);
  }
}
