package ASSIGNMENT1;

// Q1: Write a program to check whether a number is prime or not.
import java.util.Scanner;
public class Q1 {
    static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (isPrime(n))
            System.out.printf(n + " is a prime.%n");
        else
            System.out.printf(n + " is not a prime.%n");
    }
}

/*
 * Time Complexity:
 * 
 * O(N^.5)
 * Iteration: 2 -> i*i<=n 
 * i <= sqrt(n)
 */