package sorting;

import utils.Util;

public class CheckReverseArray {
    static boolean checkReverseArray(int[] arr) {
        int stop = -1, start = -1;
        int lastElement = -1;
        boolean revSub = false;
        for (int i = 1; i < arr.length - 1; i++) {
            int x = arr[i];
            int prev = arr[i - 1];
            int next = arr[i + 1];
            if ((next - x) < 0) {
                if (!revSub) {
                    revSub = true;
                    start = x;
                    lastElement = prev;
                }
                stop = next;
            } else {
                if (revSub) {
                    if (next > start && stop > lastElement) {
                        return true;
                    } else {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        boolean
         reverse = checkReverseArray(arr);

    }
}
