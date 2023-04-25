package arrays;

import java.util.HashSet;

import utils.Util;

public class FindSumDistinct {
    static int findSumDistinct(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        
        int sum = 0;
        for (int x : arr) {
            if (!hashSet.contains(x)) {
                sum += x;
            }
            hashSet.add(x);
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int sum = findSumDistinct(arr);
        System.out.printf("Sum of distinct = %d%n", sum);

    }
}
