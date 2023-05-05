package recursion;

import utils.Util;

public class Permutation {
    static int iterations = 0;

    static void permute(String[] arr, int i, int length) {
        if (length == i) {
            Util.display(arr, "Array = ");
            return;
        }
        for (int j = i; j < length; j++) {
            Util.swap(arr, i, j);
            permute(arr, i + 1, length);
            Util.swap(arr, i, j);
        }
        return;
    }

    public static void main(String[] args) {
        String[] arr = { "a", "b", "c", "d", "e" };
        permute(arr, 0, arr.length);
    }
}
