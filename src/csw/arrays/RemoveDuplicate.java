package arrays;
import java.util.LinkedHashSet;

import utils.Util;

// Remove duplicate in a given integer list.
public class RemoveDuplicate {
    static int[] removeDuplicate(int[] arr) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int x : arr) {
            linkedHashSet.add(x);
        }
        int[] uniqueArr = new int[linkedHashSet.size()];
        int index = 0;
        for (int x : linkedHashSet) {
            uniqueArr[index++] = x;
        }
        return uniqueArr;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int[] uniques = removeDuplicate(arr);
        Util.display(uniques, "Array after removing duplicates: ");
    }
}
