package linkedlist;

public class DoubleLinkedList<T extends Comparable<T>> implements LinkedListInterface<T> {
    class Node {
        Node next;
        Node prev;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    Node start, end;

    public int length() {
        Node current = start;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    @Override
    public void insertBeg(T data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = end = newNode;
        } else {
            newNode.next = start;
            start.prev = newNode;
            start = newNode;
        }
    }

    @Override
    public void insertEnd(T data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = end = newNode;
        } else {
            newNode.prev = end;
            end.next = newNode;
            end = newNode;
        }
    }

    Node travelAny(int index) {
        Node current = start;
        int count = 0;
        while (++count < index) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void insertAny(int index, T data) {
        int MAX = length();
        Node node = new Node(data);
        if (index > MAX || index < 0) {
            System.out.println("Can't insert at " + index);
        } else if (index == MAX) {
            insertEnd(data);
        } else if (index == 0) {
            insertBeg(data);
        } else {
            Node prevIndex = travelAny(index);
            Node currentIndex = prevIndex.next;
            prevIndex.next = node;
            node.next = currentIndex;
            currentIndex.prev = node;
            node.prev = prevIndex;
        }
        display();
    }

    @Override
    public void deleteBeg() {
        if (start != null) {
            start = start.next;
            start.prev = null;
        }
    }

    @Override
    public void deleteEnd() {
        if (end != null) {
            end = end.prev;
            end.next = null;
        }
    }

    @Override
    public void deleteAny(int index) {
        int MAX = length();
        if (index > MAX || index < 0) {
            System.out.println("Can't insert at " + index);
        } else if (index == MAX) {
            deleteEnd();
        } else if (index == 0) {
            deleteBeg();
        } else {
            Node prevIndex = travelAny(index);
            Node nextIndex = prevIndex.next.next;
            prevIndex.next = nextIndex;
            nextIndex.prev = prevIndex;
        }
        display();
    }

    /**
     * 
     * @param element Any element in LinkedList to be deleted
     * @return true if found else false
     */
    public boolean deleteAnyElement(T element) {
        Node currNode = start;
        if (start.data.equals(element)) {
            deleteBeg();
            return true;
        }
        if (end.data.equals(element)) {
            deleteEnd();
            return true;
        }
        while (currNode != null) {
            if (currNode.data.equals(element)) {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    @Override
    public void sort() {

    }

    public void display() {
        display("");
    }

    @Override
    public void display(String message) {
        System.out.println(message);
        Node current = start;
        while (current != end) {
            System.out.print(current.data + " <=> ");
            current = current.next;
        }
        System.out.print(current.data + "\n");
    }

    public void displayReverse(String message) {
        System.out.println(message);
        Node current = end;
        while (current != start) {
            System.out.print(current.data + " <=> ");
            current = current.prev;
        }
        System.out.print(current.data + "\n");
    }

    public void addElementsSortedOrder(T value) {
        Node currNode = start;
        Node newNode = new Node(value);
        if (currNode == null || value.compareTo(currNode.data) < 0) {
            insertBeg(value);
            return;
        }
        while (currNode.next != null && currNode.next.data.compareTo(value) < 0) {
            currNode = currNode.next;
        }
        // Node nextNode = currNode.next;
        if (currNode.next == null) {
            insertEnd(value);
            return;
        }
        // currNode.next = nextNode;
        newNode.prev = currNode;
        newNode.next = currNode.next;
        currNode.next.prev = newNode;
        currNode.next = newNode;
    }

    @Override
    public boolean searchElement(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchElement'");
    }
}

class MainProgram {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.addElementsSortedOrder(234);
        dll.addElementsSortedOrder(4324);
        dll.addElementsSortedOrder(433);
        dll.addElementsSortedOrder(5435);
        dll.addElementsSortedOrder(554);
        dll.addElementsSortedOrder(1383);
        dll.addElementsSortedOrder(4);
        dll.display("LinkedList sorted order: ");
        dll.deleteAnyElement(4324);
        dll.display("After deleting elemnt: ");
        dll.deleteAnyElement(234);
        dll.display("After deleting elemnt: ");
        dll.deleteAnyElement(4);
        dll.display("After deleting elemnt: ");
        dll.deleteAnyElement(5435);
        dll.display("After deleting elemnt: ");
        // dll.insertAny(1, 1);
        // dll.deleteAny(2);
        // dll.deleteBeg();
        // dll.deleteEnd();

    }

}
