package ASSIGNMENT2B;

import java.util.HashSet;
import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.print("Enter the value of N: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("Enter all numbers: ");
        while (n-- > 0) {
            hashSet.add(sc.nextInt());
        }
        System.out.println(hashSet);
    }
}
