package recursion;

public class DecimalToHexadecimal {
    static String[] arr = {"A", "B", "C", "D", "E", "F"}; 
    static String returnHexValueString(int rem){
        if (rem>=10){
            return arr[rem-10];
        }
        return String.valueOf(rem);
    }
    static String decimalToHex(int decimal, String hex){
        if (decimal==0){
            return hex;
        }
        return decimalToHex(decimal/16, returnHexValueString(decimal%16) + hex); 
    }
    static String decimalToHex(int x){
        return decimalToHex(x, "");
    }
    public static void main(String[] args) {
        System.out.println("Hexadecimal = " + decimalToHex(31));
    }
}
