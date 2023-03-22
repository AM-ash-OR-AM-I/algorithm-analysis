package utils;
public class PrintArray {
    static public void display(int[] arr, String msg){
        String s = "";
        for (int i=0; i<arr.length; i++){
            if (i == (arr.length-1)){
                s += arr[i];
            } else {
                s+= arr[i]+", ";
            }
        }
        System.out.println(msg + s);
    }
}
