package linkedlist;

public class CopyLinkedListReverse {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Integer[] arr = { 4534, 23, 345, 234, 34, 324, 23, 3242, 12 };
        for (Integer integer : arr) {
            linkedList.insertEnd(integer);
        }
        // linkedList.display("Sorted");
        LinkedList<Integer> newLL = linkedList.copyLinkedListReverse();
        newLL.display("Reversed LinkedList: ");
    }
}
