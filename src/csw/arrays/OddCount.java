package arrays;

import utils.Util;

/*
 * Given an array in which all the elements appear even number of times
 * except one, which appear odd number of times. Find the element which appear
 * odd number of times
 * 
 * Use XOR sum (as xor of same element gives zero (5^5 = 0)), the element that appears odd number times
 * won't be cancelled out 
 */
public class OddCount {
    static int oddCount(int[] arr) {
        int xorSum = 0;
        for (int x : arr) {
            xorSum ^= x;
        }
        return xorSum;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int odd = oddCount(arr);
        System.out.println(odd + " appears odd number times");
    }
}
