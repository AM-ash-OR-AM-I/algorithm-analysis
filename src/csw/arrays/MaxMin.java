package arrays;
import utils.PrintArray;

/*
 * 10. Given a sorted Array, arrange it maximum, minimum form.
 */
public class MaxMin {
    static int[] maxMin(int[] arr){
        int n = arr.length;
        int index = 0;
        int newArr[] = new int[n];
        for (int i=0, j=n-1; (i<=n/2 && j>=n/2) ;i++, j--){
            newArr[index++] = arr[i];
            newArr[index++] = arr[j];
        }
        return newArr;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] newArr = maxMin(arr);
        PrintArray.display(newArr, "Array = ");
    }
}
