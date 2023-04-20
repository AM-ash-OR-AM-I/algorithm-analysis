package arrays;

import java.util.HashSet;

import utils.Util;

// Given an unsorted list of n elements, find first element that is repeated.
public class FindFirstRepeatition {
    static int findFirstRepeatition(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int x : arr) {
            if (hashSet.contains(x)) {
                return x;
            } else {
                hashSet.add(x);
            }
        }
        System.out.println("No element is repeated");
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int x = findFirstRepeatition(arr);
        if (x != -1) {
            System.out.println("First element repeated = " + findFirstRepeatition(arr));
        }

    }
}
