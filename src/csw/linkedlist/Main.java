package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Integer[] arr = { 4534, 23, 345, 234, 34, 324, 23, 3242, 12 };
        for (Integer integer : arr) {
            linkedList.insertSorted(integer);
            linkedList.display("Linked list sorted order: ");
        }
        linkedList.display("Linked list Before Sorting: ");
        // linkedList.sort();
        // linkedList.insertAny(1, 466);
        // linkedList.display("Linked List After sorting: ");
        // linkedList.reverse();
        // linkedList.display("Linked List after reverse: ");
        // linkedList.deleteEnd();
        // linkedList.deleteEnd();
        // linkedList.display("Linked List after deleting end.");
        // linkedList.deleteBeg();
        // linkedList.display("Linked List after deleting beginning.");
    }
}
