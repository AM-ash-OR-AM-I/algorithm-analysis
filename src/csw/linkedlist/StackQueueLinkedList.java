package linkedlist;
import java.util.Scanner;

class StackLList extends BaseStack{
    int length;
    StackLList(int length){
        super(length);
    }
    @Override
    public void push(int data) {
        if (length < MAX_LENGTH){
            length++;
            insertBeg(data);
        }
        else {
            System.out.println("\nOverflow: Stack is already full.");
        }
    }
    @Override
    public void pop() {
        if (start!=null){
            System.out.println("\nElement removed = "+start.data);
            start = start.next;
        }
        else {
            System.out.println("Underflow: Stack is Empty");
        }
    }
    @Override
    public void displayStack(){
        Node current = start;
        System.out.println("\n::STACK::");
        while (current!=null){
            if (current==start)
                System.out.printf("| %-5s | --> TOP%n",current.data);
            else
                System.out.printf("| %-5s |%n",current.data);
            current = current.next;
        }
    }
}

class QueueLList extends BaseQueue{
    int length;
    QueueLList(int length){
        super(length);
    }
    @Override
    public void enqueue(int data) {
        if (length < MAX_LENGTH){
            length++;
            insertEnd(data);
        }
        else System.out.println("Queue is full can't add.");
    }

    @Override
    public void dequeue() {
        if (start!=null){
            length--;
            System.out.println("\nElement removed = "+start.data);
            start = start.next;
        }
        else System.out.println("Queue is already empty.");
    }

    @Override
    public void displayQueue() {
        Node current = start;
        System.out.println("\n::QUEUE::");
        String msg;
        while (current!=null){
            if (start==end)
                System.out.printf("| %-5s | -> FRONT & REAR %n", current.data);
            else if (current==start)
                System.out.printf("| %-5s | -> FRONT%n", current.data);
            else if (current.next==null)
                System.out.printf("| %-5s | -> REAR%n", current.data);
            else
                System.out.printf("| %-5s |%n", current.data);
            current = current.next;
        }
    }
}

public class StackQueueLinkedList {
    public static void main(String[] args) {
        StackLList stack = new StackLList(3);
//        QueueInterface queue = new QueueLList(3); // Gives access to only methods of queue.
//        queue.menu();
    }
}
