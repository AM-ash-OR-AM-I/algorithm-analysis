package arrays;
import java.util.HashSet;

/*
 * 9. Given an unsorted array, find smallest positive number missing in the array.
 * arr = {2, 3, 4, 7, 1, 6}, n = 6, range = n+1 = 7, return 5
 * arr = {6, 4, 2, 3, 5, 1}, return -1
 */
public class SmallestMissing {

    /*
     * T(n) = O(n) most efficient sol.
     */
    static int smallestMissing(int[] arr){
        int n = arr.length;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0; i< n; i++){
            hashSet.add(arr[i]);
        }
        
        for (int x=1; x<=n; x++){
            if (!hashSet.contains(x)){
                return x;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 5, 7, 1};
        System.out.println("Smallest missing element: " + smallestMissing(arr));
    }
}
