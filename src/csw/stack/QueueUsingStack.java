package stack;

import java.util.Iterator;
import java.util.Stack;

class QueueStack<T> {
    Stack<T> stack1;
    Stack<T> stack2;

    QueueStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    void enqueue(T element) {
        stack1.push(element);
    }

    void dequeue() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.pop();
    }

    void displayQueue() {

        System.out.println(stack1 + "  " + stack2);
        Iterator<T> iterator = stack1.iterator();
        while (iterator.hasNext()){
            
        }

    }
}

public class QueueUsingStack {

    public static void main(String[] args) {
        QueueStack<Integer> queueStack = new QueueStack();
        queueStack.enqueue(3);
        queueStack.enqueue(4);
        queueStack.enqueue(5);
        queueStack.enqueue(6);
        queueStack.enqueue(7);
        queueStack.dequeue();
        queueStack.displayQueue();
        queueStack.dequeue();
        queueStack.displayQueue();
        queueStack.dequeue();
        queueStack.displayQueue();
        queueStack.dequeue();
        queueStack.displayQueue();

    }
}
