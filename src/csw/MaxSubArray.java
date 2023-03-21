import java.util.*;
class MaxSubArray {

    static int maxSubArray(int[] arr, int n){
        int maxVaint n = arr.length;
        int maxValue = -1;
        int negativeMax = Integer.MIN_VALUE;
        int currentValue = 0;
        for (int x: arr){
            negativeMax = Math.max(negativeMax, x);
            currentValue += x;
            if (currentValue>0){
                maxValue = Math.max(currentValue, maxValue);
            } else {
                currentValue = 0;
            }
        }
        if (maxValue==-1){
            return negativeMax;
        }
        return maxValue;
    }
    public static void main(String[] args){
        int[] arr = {-1, -2, 3, 4, -4, 6, -4, 3, 2};
        int max = maxSubArray(arr, arr.length);
        System.out.println("Max value = "+ max);
    }
}