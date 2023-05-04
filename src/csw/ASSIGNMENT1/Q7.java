package ASSIGNMENT1;

import java.util.Arrays;

import utils.Util;

public class Q7 {
    static void waveForm(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i += 2) {
            if (arr[i - 1] < arr[i]) {
                Util.swap(arr, i, i - 1);
            }
            if ((i + 1) < n && arr[i + 1] < arr[i]) {
                Util.swap(arr, i, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        waveForm(arr);
        System.out.println(Arrays.toString(arr));
    }
}
