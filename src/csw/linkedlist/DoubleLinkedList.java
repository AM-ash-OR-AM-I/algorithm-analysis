package linkedlist;
public class DoubleLinkedList <T> implements LinkedListInterface<T>{
    class Node{
        Node next;
        Node prev;
        T data;
        Node(T data){
            this.data = data;
        }
    }

    Node start, end;

    public int length(){
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
        if (start==null){
            start = end = newNode;
        }
        else {
            newNode.next = start;
            start.prev = newNode;
            start = newNode;
        }
    }

    @Override
    public void insertEnd(T data){
        Node newNode = new Node(data);
        if (start==null){
            start = end = newNode;
        }
        else{
            newNode.prev = end;
            end.next = newNode;
            end = newNode;
        }
    }

    Node travelAny(int index){
        Node current = start;
        int count = 0;
        while (++count<index){
            current = current.next;
        }
        return current;
    }

    @Override
    public void insertAny(int index, T data) {
        int MAX = length();
        Node node = new Node(data);
        if (index>MAX || index<0){
            System.out.println("Can't insert at "+index);
        }
        else if (index==MAX){
            insertEnd(data);
        }
        else if (index==0){
            insertBeg(data);
        }
        else{
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
        start = start.next;
        display();
    }

    @Override
    public void deleteEnd() {
        end = end.prev;
        display();
    }

    @Override
    public void deleteAny(int index) {
        int MAX = length();
        if (index>MAX || index<0){
            System.out.println("Can't insert at "+index);
        }
        else if (index==MAX){
            deleteEnd();
        }
        else if (index==0){
            deleteBeg();
        }
        else{
            Node prevIndex = travelAny(index);
            Node nextIndex = prevIndex.next.next;
            prevIndex.next = nextIndex;
            nextIndex.prev = prevIndex;
        }
        display();
    }

    @Override
    public void sort() {

    }

    public void display(){
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
}

class MainProgram{
    public static void main(String[] args) {
        DoubleLinkedList <Integer> dll = new DoubleLinkedList<>();
        dll.insertEnd(234);
        dll.insertBeg(4324);
        dll.insertEnd(433);
        dll.insertAny(1, 1);
        dll.deleteAny(2);
        dll.deleteBeg();
        dll.deleteEnd();

    }
}
