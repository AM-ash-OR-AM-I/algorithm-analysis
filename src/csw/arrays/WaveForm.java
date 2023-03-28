package arrays;
// Q6: Arrange elements of an array, such that odd indexed elements are lesser than its neighbour even indexed elements.

import utils.Util;

class WaveForm{
    static void oddEven(int[] arr){
        int n = arr.length;
        if (n==1){
            return;
        }
        for (int i = 1; i <= (n-1) ; i+=2){
            if (i==(n-1) && (arr[i-1] > arr[i])){
                Util.swap(arr, i-1, i);
            } else {
                if ((arr[i-1] < arr[i]) && (arr[i-1] < arr[i+1])){
                    Util.swap(arr, i-1, i);
                } else if ((arr[i+1] < arr[i]) && (arr[i+1] < arr[i+1])) {
                    Util.swap(arr, i+1, i);
                }
            }
        }
    } 
    public static void main(String[] args){
        int[] arr = {2, 3, 4, 54, 75, 3244342, 433};
        oddEven(arr);
        Util.display(arr, "WaveForm Odd- even: ");
    }
}