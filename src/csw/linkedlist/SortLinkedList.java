package linkedlist;

class BubbleSortArray<T extends Comparable<T>> {
    T[] arr;

    BubbleSortArray(T[] arr) {
        this.arr = arr;
    }

    public void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sort() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < (arr.length - i - 1); j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0)
                    swap(j, j + 1);
            }
        }
        display();
    }

    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class BubbleSortLinkedList<T extends Comparable<T>> {
    LinkedList<T> linkedList;
    LinkedList<T>.Node start;
    LinkedList<T>.Node current;
    BubbleSortLinkedList(LinkedList<T> linkedList){
        this.linkedList = linkedList;
        start = linkedList.start;
    }

    void swap(LinkedList<T>.Node node1, LinkedList<T>.Node node2){
        T temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    void sort(){
         int n = linkedList.length();
         for (int i = 0; i < n - 1; i++) {
             current = start;
             for (int j = 0; j < (n - i - 1); j++) {
                 if (current.data.compareTo(current.next.data) > 0)
                     swap(current, current.next);
                 current = current.next;
             }
         }
    }


}


class SortArray {
    public static void main(String[] args) {
        LinkedList<Integer> link = new LinkedList<>();
        int[] arr = {8, 12, 7, 9, 3 , 4, 2, 7, 1};
        for(int i = 0; i< arr.length; i++){
            link.insertEnd(arr[i]);
        }
        link.display("Before Sorting");
        BubbleSortLinkedList <Integer> sortLinked = new BubbleSortLinkedList<>(link);
        sortLinked.sort();
        link.display("Sorted Array: ");

    }
}