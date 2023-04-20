package arrays;

import java.util.HashSet;

import utils.Util;

public class FindMissingElement {
    static int findMissing(int[] arr, int size) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int x : arr) {
            hashSet.add(x);
        }

        for (int i = 1; i <= size; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int missing = findMissing(arr, arr.length);
        System.out.println("Missing element = " + missing);
    }
}
