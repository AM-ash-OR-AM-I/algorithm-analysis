package arrays;
/*
 * 12. MaxDistance
 * Given an array arr[], find maximum distance of index j and i, such
 * that arr[j] > arr[i] (assuming j>i)
 * [20, 18, 16, 14, 10, 15]
 */
public class MaxDistanceIndex {
    // TODO: optimise it
    static int findMaxDist(int[] arr){
        int n = arr.length;
        for (int i = n; i>1; i--){
            for (int j = 0; j<(n-i+1); j++){
                if(arr[j+(i-1)]> arr[j]){
                    return i-1;
                }
            } 
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {78, 3, 342, 324, 56, 3, 56};
        int max = findMaxDist(arr);
        System.out.println("Max = "+max);
    }
}
