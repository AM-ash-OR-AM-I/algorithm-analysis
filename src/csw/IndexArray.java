import utils.PrintArray;

/* 
 * Given array of size N, containing elements from 0 to N-1. All values
 * from 0 to N-1 are present in array and if they are not there than -1 is there to take
 * its place. Arrange values of array so that value i is stored at arr[i]
 */
public class IndexArray {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * Same time complexity but uses a extra Array. 
     */
    static int[] newArray(int[] arr){
        int[] newArray =  new int[arr.length];
        for (int i=0; i<arr.length; i++){
            newArray[i] = -1;
        }
        for (int i=0; i< arr.length; i++){
            int val = arr[i];
            if (val!=-1){
                newArray[val] = val;
            }
        }
        return newArray;
    }
    
    /*
     * Zero overhead, runs <=n times. Most efficient though asymptotically bot are O(N)
     */
    static void replaceArray(int[] arr){
        for (int i=0; i< arr.length; i++){
            while (arr[i]!=-1 && arr[i]!=i){
                swap(arr, i, arr[i]);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 1, 5, -1, -1, 7, 8};
        // int[] newArr = newArray(arr);
        replaceArray(arr);
        PrintArray.display(arr, "IndexArry = ");
    }
}
