package linkedlist;

public class CircularLinkedList<T> implements LinkedListInterface<T>{
    class Node{
        Node next;
        T data;
        Node(T data){
            this.data = data;
        }
    }

    Node end;

    @Override
    public void insertBeg(T data) {
        Node node = new Node(data);
        if (end==null){
            end = node;
            end.next = end;
        }
        else{
            node.next = end.next;
            end.next = node;
        }
    }

    @Override
    public void insertEnd(T data) {
        Node node = new Node(data);
        if (end == null) {
            end = node;
            end.next = end;
        } else {
            node.next = end.next;
            end.next = node;
            end = node;
        }

    }
    
    Node travelTo(int index) {
        Node current = end.next;
        int count = 0;
        while (++count < index) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void insertAny(int index, T data) {
        Node node = new Node(data);
        if (index==0){
            insertBeg(data);
        }
        else if (index==count()){
            insertEnd(data);
        }
        else{
            Node current = travelTo(index);
            node.next = current.next;
            current.next = node;
        }
    }

    @Override
    public void deleteBeg() {

    }

    @Override
    public void deleteEnd() {

    }

    @Override
    public void deleteAny(int index) {

    }

    @Override
    public void sort() {

    }

    @Override
    public void display(String message) {
        Node temp = end.next; // start value
        int count = 1;
        while(temp!=end){
            count++;
            System.out.printf("-> %-5s ",temp.data);
            temp = temp.next;
        }
        System.out.printf("-> %-5s ->\n",temp.data);
        System.out.printf("<%s<%n","-".repeat(count*9));
    }

    public int count() {
        if (end==null)
            return 0;

        Node temp = end;
        int count = 1;
        while (temp.next!=end){
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
}

class MainCLL {
    public static void main(String[] args) {
        CircularLinkedList<Integer> cll = new CircularLinkedList<>();
        cll.insertEnd(3424);
        cll.insertEnd(234);
        cll.insertBeg(56754);
        cll.insertAny(1, 12);
        cll.display("");
    }
}
