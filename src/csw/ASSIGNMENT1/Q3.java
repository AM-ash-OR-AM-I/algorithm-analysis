package ASSIGNMENT1;

// Q3: Find reverse of a number
public class Q3 {
    static int reverse(int n) {
        String s = String.valueOf(n);
        int length = s.length();
        String rev = "";
        for (int i = length - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return Integer.parseInt(rev);
    }

    public static void main(String[] args) {
        int n = 2545435;
        System.out.printf("Reverse of %d is %d%n", n, reverse(n));
    }
}

/*
 * T(n) = O(n)
 * Since it runs for entire string
 */
