package ASSIGNMENT1;

/*
 * Given an unsorted array, find the smallest positive number missing in the array.
 */

public class Q9 {
    static int findSmallestMissing(int[] arr){
        /*
         * [1, 3, 5, 12] -> 4
         */
        // TODO:
        int minPositive = Integer.MAX_VALUE;
        for(int i=0; i< arr.length; i++){
            minPositive = Math.min(minPositive, arr[i]);
        }

    }
    public static void main(String[] args) {

    }
}
