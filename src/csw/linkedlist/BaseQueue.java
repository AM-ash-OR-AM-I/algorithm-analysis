package linkedlist;

import java.util.Scanner;

abstract class BaseQueue extends LinkedList<Integer>{
    int MAX_LENGTH;
    Scanner sc = new Scanner(System.in);
    String MENU = """
                ** QUEUE MENU **
                1. Enqueue
                2. Dequeue
                3. Display
                Any other number to show menu.
                """;

    BaseQueue(int max_length){
        MAX_LENGTH = max_length;
    }
    abstract void enqueue(int data);
    abstract void dequeue();
    abstract void displayQueue();
    void menu(){
        System.out.println(MENU);
        int choice = 1;
        while(choice!=0){
            switch (choice){
                case 1 -> {
                    System.out.print("Enter the string: ");
                    int elem = sc.nextInt();
                    enqueue(elem);
                }
                case 2 -> dequeue();
                case 3 -> displayQueue();
                default -> System.out.println(MENU);

            }
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
        }

    }
}