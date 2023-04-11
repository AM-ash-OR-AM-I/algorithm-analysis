package ASSIGNMENT1;

// Q2: Find binary Equivalent of decimal Number
import java.util.Scanner;
public class Q2 {
    static String decimalToBString(int n) {
        if (n == 0)
            return "0";
        String bin = "";
        while (n > 0) {
            bin = String.valueOf(n % 2) + bin;
            n /= 2;
        }
        return bin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int n = sc.nextInt();
        String binary = decimalToBString(n);
        System.out.println(binary);
    }
}

/*
 * T(n) = O(log(n))
 */