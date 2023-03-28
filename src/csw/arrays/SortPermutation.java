package arrays;
import utils.Util;

/*
 * 8. Given an array of length n, it contains unique elements from 1-n and sort the elements.
 */

class SortPermutation{
    static void sortArray(int[] arr){
        for (int i =0 ; i< arr.length; i++){
            arr[i] = i+1;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4, 6};
        sortArray(arr);
        Util.display(arr, "Sorted Array = ");
    }
}