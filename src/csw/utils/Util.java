package utils;

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
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == (arr.length - 1)) {
                s += arr[i];
            } else {
                s += arr[i] + ", ";
            }
        }
        System.out.println(msg + s);
    }

    static public void display(int[] arr, String msg) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == (arr.length - 1)) {
                s += arr[i];
            } else {
                s += arr[i] + ", ";
            }
        }
        System.out.println(msg + s);
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