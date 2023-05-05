package ASSIGNMENT1;

import java.util.Scanner;

/*
 * Write a recursive function to find the GCD of two numbers. Write the
recurrence of the function and solve it for a solution.
 */

public class Q15 {
    static int findGCD(int a, int b) {
        if (a % b == 0)
            return b;
        return findGCD(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        int gcd = findGCD(a, b);
        System.out.println("GCD = " + gcd);
    }
}
