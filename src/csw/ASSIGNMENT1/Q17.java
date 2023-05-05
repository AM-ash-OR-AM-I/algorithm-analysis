package ASSIGNMENT1;

// Q17 : Recursive function using Binary Search

public class Q17 {
    static int binSearch(int[] arr, int low, int high, int x) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (x == arr[mid])
                return mid;
            else if (x < arr[mid])
                return binSearch(arr, low, mid - 1, x);
            else
                return binSearch(arr, mid + 1, high, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 6, 4, 8, 1 };
        int index = binSearch(arr, 0, arr.length - 1, 4);
        System.out.printf("Element found at index: %s", index);
    }
}

/*
 * T(n) = T(n/2) + O(1)
 * T(n) = O(logn)
 * Since, in each step array gets divided into 2 part.
 */