package sorting.heap;
import java.util.Collections;
import java.util.PriorityQueue;

public class BuildHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = {1, 2, 10, 8, 7, 3, 4, 6, 5, 9};
        for (int x: arr){
            pq.add(x);
        }
        System.out.println("Printing pq: " + pq);
        while(!pq.isEmpty()){
            System.out.println("Element removed: " + pq.remove());
        }
    }
}
