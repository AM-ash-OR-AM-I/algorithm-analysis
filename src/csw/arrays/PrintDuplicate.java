package arrays;

import java.util.HashSet;

import utils.Util;

// Given and array of n numbers, print duplicate elements in the array.
public class PrintDuplicate {
    static void printDuplicate(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int x : arr) {
            if (hashSet.contains(x)) {
                System.out.print(x + ", ");
            } else {
                hashSet.add(x);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        printDuplicate(arr);
    }
}
