import java.util.*;
class BinarySeach {
    static int binarySearch(int[] arr, int low, int high, int x){
        while (low<=high){
            int mid = (low+high)/2;
            if (x == arr[mid]){
                return mid;
            } else if (x > arr[mid]){
                return binarySearch(arr, mid+1, high, x);
            } else {
                return binarySearch(arr, low, mid-1, x);
            }
        }
        return -1;
    }
    static int search(int[] arr, int x){
        int result = binarySearch(arr, 0, arr.length - 1, x);
        return result;
    }
    public static void main(String[] args){
        int[] arr = {34, 43, 432, 3424};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter integer to search: ");
        int x = sc.nextInt();
        int result = search(arr, x);
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else 
            System.out.println("Element not found");
    }
}