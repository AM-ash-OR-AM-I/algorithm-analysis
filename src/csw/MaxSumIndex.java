/*
 * 11. Given an array you need to find maximum sum of arr[i]*(i+1)
for all elements such that you are allowed to rotate the array.
 */
public class MaxSumIndex {
    static int maxSum(int[] arr){
        /*
         * T(n) = O(n^2) can be made better upto O(n)
         */
        int max = 0;
        int n = arr.length;
        for (int shift=0; shift<n; shift++){
            int sum = 0;
            for (int i=0; i<n; i++){
                int tempIndex = (i+shift)%n + 1;
                sum += arr[i]*(tempIndex);
                System.out.printf("arr[%s]*%s = %s + ", i, tempIndex, sum);
            }
            System.out.println("\nCurrent sum = "+sum);
            max = Math.max(sum, max);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int res = maxSum(arr);
        System.out.println("Max sum = "+res);
    }
}
