package ASSIGNMENT1;

import java.util.Scanner;

/*
 * Write a recursive algorithm to solve the Tower of Hanoi problem.
 */

public class Q14 {
    static void towerOfhanoi(int disc, char source, char dest, char temp) {
        if (disc == 0) {
            return;
        }
        // System.out.printf("%s %s %s %s%n", disc - 1, source, temp, dest);
        towerOfhanoi(disc - 1, source, temp, dest);
        System.out.printf("Move %s disk from peg %s to peg %s%n", disc, source, dest);
        towerOfhanoi(disc - 1, temp, dest, source);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of discs: ");
        int disc = sc.nextInt();
        towerOfhanoi(disc, 'A', 'B', 'C');
    }
}
