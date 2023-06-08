package heap;

import java.util.PriorityQueue;

import utils.Util;

public class KthSmallestHeap {
    static int findKthSmallest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr) {
            pq.add(x);
        }
        int value = 0;
        for (int i = 0; i < k && i < n; i++) {
            value = pq.remove();
        }
        return value;
    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        int kThSmallest = findKthSmallest(arr, 1);
        System.out.println(kThSmallest);
    }
}
