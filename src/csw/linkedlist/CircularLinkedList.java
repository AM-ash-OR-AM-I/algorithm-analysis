package linkedlist;

public class CircularLinkedList<T> implements LinkedListInterface<T> {
    class Node {
        Node next;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    Node start, end;

    @Override
    public void insertBeg(T data) {
        Node node = new Node(data);
        if (start == null) {
            node.next = node;
            start = node;
            end = node;
        } else {
            end.next = node;
            node.next = start;
            start = node;
        }
    }

    @Override
    public void insertEnd(T data) {
        Node node = new Node(data);
        if (end == null) {
            node.next = node;
            start = node;
            end = node;
        } else {
            end.next = node;
            node.next = start;
            end = node;
        }
    }

    Node travelTo(int index) {
        Node current = end.next;
        int count = 1;
        while (++count < index) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void insertAny(int index, T data) {
        Node node = new Node(data);
        if (index == 0) {
            insertBeg(data);
        } else if (index == count()) {
            insertEnd(data);
        } else {
            Node current = travelTo(index);
            node.next = current.next;
            current.next = node;
        }
    }

    @Override
    public void display(String message) {
        System.out.println(message);
        Node temp = start; // start value
        int count = 1;
        while (temp.next != start) {
            count++;
            System.out.printf("-> %-5s ", temp.data);
            temp = temp.next;
        }
        System.out.printf("-> %-5s ->\n", temp.data);
        System.out.printf("<%s<%n", "-".repeat(count * 9));
    }

    public int count() {
        if (start == null)
            return 0;

        Node temp = start;
        int count = 1;
        while (temp.next != end) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    @Override
    public boolean searchElement(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchElement'");
    }

    @Override
    public void deleteBeg() {
        if (start != null) {
            start = start.next;
            end.next = start;
        } else if (start.next == null) {
            start = null;
        }
    }

    @Override
    public void deleteEnd() {
        int pos = count() - 1;
        System.out.println(pos);
        if (pos == 0) {
            // TODO: fix for 1 node
            start = end = null;
            return;
        }
        Node secondLast = travelTo(pos);
        secondLast.next = start;
        end = secondLast;

    }

    @Override
    public void deleteAny(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAny'");
    }

    @Override
    public void sort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }
}

class MainCLL {
    public static void main(String[] args) {
        CircularLinkedList<Integer> cll = new CircularLinkedList<>();
        cll.insertBeg(56754);
        cll.insertBeg(432);
        cll.insertBeg(543);
        // cll.insertEnd(5435);
        // cll.insertEnd(566);
        cll.display("");
        cll.deleteBeg();
        cll.display("Delete Beg: ");
        cll.deleteEnd();
        cll.display("Delete end: ");
        cll.deleteEnd();
        cll.display("Delete end: ");
    }
}
