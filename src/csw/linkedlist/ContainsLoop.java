package linkedlist;

public class ContainsLoop {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Integer[] arr = { 4534, 23, 345, 234, 34, 324, 23, 3242, 12 };
        for (Integer integer : arr) {
            linkedList.insertSorted(integer);
            linkedList.display("Linked list sorted order: ");
        }
        System.out.println(linkedList.containsLoop());
    }
}
