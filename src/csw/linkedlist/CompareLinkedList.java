package linkedlist;

public class CompareLinkedList {
    public static boolean isEquals(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        return ll1.equals(ll2);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Integer[] arr = { 4534, 23, 345, 234, 34, 324, 23, 3242, 12 };
        for (Integer integer : arr) {
            linkedList.insertSorted(integer);
            linkedList.display("Linked list sorted order: ");
        }
        System.out.println(isEquals(linkedList, linkedList));
    }
}
