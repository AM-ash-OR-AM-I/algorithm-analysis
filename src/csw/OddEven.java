// Q6: Arrange elements of an array, such that odd indexed elements are lesser than its neighbour even indexed elements.
import java.util.*;
class OddEven{
    static void swap(int arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void oddEven(int[] arr){
        int n = arr.length;
        if (n==1){
            return;
        }
        for (int i = 1; i <= (n-1) < i+=2){
            if (i==(n-1) && (arr[i-1] > arr[i])){
                swap(i-1, i);
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {2, 3, 4, 54, 75};
        int max = oddEven(arr);
        System.out.println("Max value = "+ max);
    }
}