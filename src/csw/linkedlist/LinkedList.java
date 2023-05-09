package linkedlist;

import java.util.HashSet;

public class LinkedList<T extends Comparable<T>> implements LinkedListInterface<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    Node start, end;

    /**
     * @return length of linked list
     */
    public int length() {
        Node current = start;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    Node travelEnd() {
        Node current = start;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    /**
     * Returns node at `index-1` by iterating through linkedList.
     * 
     * @param index index of node
     * @return Node
     */
    Node travelTo(int index) {
        Node current = start;
        int count = 0;
        while (++count < index) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void insertBeg(T data) {
        // Insert at the beginning of the Node
        Node node = new Node(data);
        if (start != null)
            node.next = start;
        start = node;
    }

    /**
     * Inserts at end of Linked List
     */
    @Override
    public void insertEnd(T data) {
        Node addNode = new Node(data);
        if (start == null) {
            start = end = addNode;
        } else {
            Node current;
            if (end != null)
                current = end;
            else
                current = travelEnd(); // End value not initialised so travel till end.
            current.next = addNode;
            end = addNode;
        }
    }

    /**
     * Inserts at any index in Linked List
     * 
     * @param index index at which new node is to be inserted
     * @param data  data of new node
     */
    @Override
    public void insertAny(int index, T data) {
        if (index != 0) {
            Node addNode = new Node(data);
            if (start == null)
                start = addNode;
            else {
                Node current = travelTo(index);
                addNode.next = current.next; // node.next was null and is now pointing to current.next
                current.next = addNode; // current.next now points to node
            }
        } else
            insertBeg(data);
    }

    @Override
    public void deleteBeg() {
        if (start != null)
            start = start.next;
    }

    @Override
    public void deleteEnd() {
        /*
         * `nextNode` is required to store value of next node to check
         * when next node is the End/Last node.
         */
        Node secondLast = start;
        if (secondLast == null) { // LinkedList is empty.
            return;
        }
        if (secondLast.next == null) { // If single node is present.
            start = null;
            return;
        }
        while (secondLast.next.next != null) { // Check for last.next using secondLast.next.next
            secondLast = secondLast.next;
        }

        secondLast.next = null; // last = null
    }

    @Override
    public void deleteAny(int index) {
        if (index == 0) {
            start = start.next;
        } else {
            Node current = travelTo(index); // Returns the node previous to the Given index
            current.next = current.next.next;
        }
    }

    public void insertBefore(T data, T toSearch) {
        // Insert before given Element
        Node newNode = new Node(data);
        Node current1 = start, current2 = start;
        while (current2.data != toSearch && current2.next != null) {
            current1 = current2;
            current2 = current2.next;
        }
        newNode.next = current1.next;
        current1.next = newNode;
    }

    /**
     * Inserts after given Element
     * 
     * @param data     data of new Node
     * @param toSearch data of node after which element needs to be inserted
     */
    public void insertAfter(T data, T toSearch) {
        Node newNode = new Node(data);
        Node current = start;
        while (current.data != toSearch && current.next != null) {
            current = current.next;
        }
        newNode.next = current.next; // New node now links with the next node.
        current.next = newNode; // Previous node now links with new node
    }

    /**
     * @param swap1st 1st node to be swapped
     * @param swap0th node before 1st node
     * @param index   value of j in 2nd for loop to check if it's last node
     * @param n       length of linked list
     */
    void swapNode(Node swap1st, Node swap0th, int index, int n) {
        Node swap2nd = swap1st.next, swap3rd = swap2nd.next;

        /*
         * Check if the node is 1st and swap connection of 0th node to point to 2nd
         * like:
         * 0th 1st 2nd 3rd
         * 2 x 5 -> 4 -> 6
         * |--------->|
         */
        if (index != 0)
            swap0th.next = swap2nd;
        else
            start = swap2nd;

        /*
         * Change next of smaller node to point to bigger node
         * 0th 1st 2nd 3rd
         * ->
         * 2 5 <- 4 x 6
         * |---------->|
         */
        swap2nd.next = swap1st;

        /*
         * Check if node is 2nd last and create connection between 1st and 3rd
         * 0th 1st 2nd 3rd
         * |--------->|
         * 2 5 <- 4 x 6
         * |-------->|
         * 
         * => 2 -> 4 -> 5 -> 6
         */
        if (index != n - 2)
            swap1st.next = swap3rd;
        else {
            swap1st.next = null;
            end = swap1st;
        }
    }

    /**
     * Sorts the linked list by swapping nodes instead of data of nodes.
     */
    void sortByNode() {
        /*
         * `nextNode` is required to store value of next node to check
         * when next node is the End/Last node.
         */
        int n = length();
        Node current, previous;
        for (int i = 0; i < n - 1; i++) {
            previous = current = start;
            for (int j = 0; j < (n - i - 1); j++) {
                Node next_node = current.next;
                if (current.data.compareTo(next_node.data) > 0) {
                    swapNode(current, previous, j, n);
                    previous = next_node;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            display(String.format("Linked List at %sth step", i + 1));
        }
    }

    void swap(Node node1) {
        T temp = node1.data;
        node1.data = node1.next.data;
        node1.next.data = temp;
    }

    /**
     * Sorts LinkedList by swapping data.
     */
    public void sort() {
        int n = length();
        Node current;
        for (int i = 0; i < n - 1; i++) {
            current = start;
            for (int j = 0; j < (n - i - 1); j++) {
                Node next_node = current.next;
                if (current.data.compareTo(next_node.data) > 0)
                    swap(current);
                current = current.next;
            }
        }
        display("Sorted Linked List: ");
    }

    public void reverse() {
        Node p = start, q = p.next, r = q.next;
        p.next = null;
        q.next = p;
        while (r != null) {
            p = q;
            q = r;
            r = r.next;
            q.next = p;
        }
        start = q;
    }

    public void display(String message) {
        System.out.println(message);

        Node current = start;
        if (current == null) {
            System.out.println("No element is present");
            return;
        }
        while (current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print(current.data + "\n");
    }

    void removeDuplicate() {
        HashSet<T> hashSet = new HashSet<>();
        Node current = start, prev = null;
        while (current != null) {
            if (hashSet.contains(current.data)) {
                if (current.next == null) { // If it's the last node
                    prev.next = null;
                    end = prev;
                } else
                    prev.next = current.next;
            }
            hashSet.add(current.data);
            prev = current;
            current = current.next;
        }
        display("Linked list after removing duplicates: ");
    }

}