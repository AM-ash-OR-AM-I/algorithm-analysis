package greedy;
import java.util.HashMap;

class Node<K, V> {
  K key;
  V value;
  Node<K, V> nextNode;
  Node<K, V> prevNode;

  Node(K key, V value) {
    this.key = key;
    this.value = value;
  }
}

class DoubleLinkedList<K, V> {
  Node<K, V> front, rear;
  HashMap<K, Node<K, V>> hashNode = new HashMap<>();
  static int maxLength;
  int length = 0;

  DoubleLinkedList(int length) {
    maxLength = length;
  }

  void add(K key, V value) {
    if (length < maxLength) {
      length++;
      Node<K, V> newNode = new Node<K, V>(key, value);
      if (front == null) {
        front = rear = newNode;
      } else {
        newNode.prevNode = rear;
        rear.nextNode = newNode;
        rear = rear.nextNode;
      }
      hashNode.put(key, newNode);

    } else {
      System.out.println("Max length of queue execeeded.");
    }
  }

  V remove(K key, String choice) {
    // Unlinks the node from the linked list
    V value = null;
    if (hashNode.containsKey(key)) {
      length--;
      Node<K, V> removeNode = hashNode.get(key);
      Node<K, V> nextNode = removeNode.nextNode;
      Node<K, V> prevNode = removeNode.prevNode;
      if (removeNode == front) {
        value = removeFront();
      } else if (removeNode == rear) {
        value = removeRear();
      } else {
        prevNode.nextNode = nextNode;
        nextNode.prevNode = prevNode;
        value = removeNode.value;
        hashNode.remove(key);
      }
    } else if (length == maxLength && choice == "put") {
      length--;
      removeFront();
    }
    return value;
  }

  V removeFront() {
    if (length == -1) {
      System.out.println("Queue is empty");
      return null;
    } else {
      V removed = front.value;
      hashNode.remove(front.key);
      front = front.nextNode;
      return removed;
    }
  }

  V removeRear() {
    if (length == 0) {
      System.out.println("Queue is empty");
      return null;
    } else {
      V removed = rear.value;
      hashNode.remove(rear.key);
      rear = rear.prevNode;
      rear.nextNode = null;
      return removed;
    }
  }

  void display() {
    if (length > 0) {
      System.out.print("Queue = ");
      Node<K, V> curNode = front;
      if (length == 1) {
        System.out.printf("{%s : %s}%n", front.key, front.value);
      } else {
        System.out.printf("{%s : %s, ", front.key, front.value);
        curNode = curNode.nextNode;
        while (curNode != rear) {
          System.out.printf("%s: %s, ", curNode.key, curNode.value);
          curNode = curNode.nextNode;
        }
        System.out.printf("%s: %s}%n", rear.key, rear.value);
      }
    }

  }
}

public class LRUCache {
  DoubleLinkedList<Integer, Integer> dll;
  int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    dll = new DoubleLinkedList<>(capacity);
  }

  public int get(int key) {
    // System.out.printf("%nget(%d)%n", key);
    Integer value = dll.remove(key, "get");
    if (value != null)
      dll.add(key, value);
    dll.display();
    return value == null ? -1 : value;
  }

  public void put(int key, int value) {
    // System.out.printf("%nput(%d, %d)%n", key, value);
    dll.remove(key, "put");
    dll.add(key, value);
    dll.display();

  }

}