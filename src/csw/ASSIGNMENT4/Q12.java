package ASSIGNMENT4;

import java.util.Scanner;

import utils.Util;

public class Q12 {
    static void sumOfPairValue(int[] arr1, int[] arr2, int value){
        // T(n) = o(n^2)
        for (int x: arr1){
            for (int y: arr2){
                if (x+y==value){
                    System.out.printf("x=%s, y=%s, x+y=%s%n", x, y, value);
                    return;
                }
            }
        }
        System.out.println("No such pair found");
    }
    public static void main(String[] args) {
        int[] arr1 = Util.takeUserInput();
        int[] arr2 = Util.takeUserInput();
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        sumOfPairValue(arr1, arr2, value);
    }
}
