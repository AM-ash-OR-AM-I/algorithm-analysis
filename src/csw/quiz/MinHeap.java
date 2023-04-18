package quiz;

import java.util.PriorityQueue;

import utils.Util;

public class MinHeap {
    static void buildMinHeap(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : arr) {
            minHeap.add(x);
        }
        
        // Created MinHeap..
        System.out.println("MinHeap = " + minHeap);
        
        System.out.println("Elements in ascending order: ");
        while(!minHeap.isEmpty()){
            System.out.print(minHeap.remove() + ", ");
        }

    }

    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        buildMinHeap(arr);
    }
}
