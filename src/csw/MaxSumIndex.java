/*
 * 11. Given an array you need to find maximum sum of arr[i]*(i+1)
for all elements such that you are allowed to rotate the array.
 */
public class MaxSumIndex {
    static int maxSum(int[] arr){
        /*
         * T(n) = O(n)
         *
         */
        int n = arr.length;
        int sum = 0;
        int max = 0;
        for (int i=0; i<n; i++){
            sum += arr[i];
        }
        for (int i=0; i<n; i++){
            max += (i+1)*arr[i];
        }
        int tempMax = max;
        for (int i=0; i<(n-1); i++){
            /* 
             * n*arr[i] => each element is placed at last index, and that means all other elements index are decreased by 1
             * e.g. [5, 1, 2, 3, 4]
             *         /  /  /  /
             *      [1, 2, 3, 4, 5] difference = 5*5 - ((-1)+(-2)+(-3)+(-4)+(-5))
             * 
             */
            int diff = arr[i]*n - sum;
            tempMax = tempMax + diff;
            System.out.println(tempMax);
            max = Math.max(tempMax, max);
        }
        return max;
        
    }
    
    static int maxSumN2(int[] arr){
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
                // System.out.printf("arr[%s]*%s = %s + ", i, tempIndex, sum);
            }
            // System.out.println("\nCurrent sum = "+sum);
            max = Math.max(sum, max);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {15, 6, 4, 3, 2, 1};
        // int res1 = maxSumN2(arr);
        int res2 = maxSum(arr);
        System.out.printf("Max sum = %s, %s%n", res2);
    }
}
