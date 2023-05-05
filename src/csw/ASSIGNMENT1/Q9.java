package ASSIGNMENT1;

import java.util.HashSet;

import utils.Util;

/*
 * Given an unsorted array, find the smallest positive number missing in the array.
 */

public class Q9 {
    static int findSmallestMissing(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int x : arr) {
            hashSet.add(x);
        }
        int n = 1;
        while (!hashSet.isEmpty()) {
            if (!hashSet.contains(n)) { // -> O(1)
                return n;
            } else {
                hashSet.remove(n);
            }
            n++;
        }
        return Integer.MAX_VALUE;

    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int smallest = findSmallestMissing(arr);
        System.out.println(smallest);
    }
}


/*
 * O/P:
 * 1 3 4 5 12
 * 2
 * 
 * Time complexity:
 * T(N) = O(N)
 */