package utils;

import java.util.Arrays;
import java.util.Scanner;

public class Util {
    static Scanner sc = new Scanner(System.in);

    static public int[] takeUserInput() {
        System.out.println("Enter the array elements seprated by spaces: ");
        String inputs = sc.nextLine();
        String[] strArr = inputs.split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }

    static public <T> void display(T[] arr, String msg) {
        System.out.printf("%s %s%n", msg, Arrays.toString(arr));
    }

    static public void display(int[] arr, String msg) {
        System.out.printf("%s %s%n", msg, Arrays.toString(arr));
    }

    static public <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
