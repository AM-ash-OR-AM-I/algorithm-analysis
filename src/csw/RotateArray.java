import java.util.*;
public class RotateArray{
    static int iterations = 0;
    static void rotateArray(int[] arr, int k){
        int[] rightSubArray = new int[k];
        int n = arr.length;
        k = k%n;
        int rest = arr.length - k;
        for (int i = 0; i<k; i++){
            iterations +=1;
            rightSubArray[i] = arr[i];
        }

        for (int i=0; i < rest; i++){
            iterations +=1;
            arr[i] = arr[i+k];
        }

        for (int i = 0; i<k; i++){
            iterations +=1;
            arr[rest + i] = rightSubArray[i];
        }
        

    }

    static void display(int[] arr){
        String s = "";
        for (int x: arr){
            s+= x+", ";
        }
        System.out.println("No. of iterarions: " + iterations);
        System.out.println("Rotated Array: " + s);
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rotations: ");
        int k = sc.nextInt();
        rotateArray(arr, k);
        display(arr);
        
        /**
        Time complexity = O(N)
         */

    }
}