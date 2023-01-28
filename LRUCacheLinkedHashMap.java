package AD;

import java.util.LinkedHashMap;

public class LRUCacheLinkedHashMap {
  LinkedHashMap<Integer, Integer> ll;
  int capacity;

  public LRUCacheLinkedHashMap(int capacity) {
    this.capacity = capacity;
    ll = new LinkedHashMap<>(capacity);
  }

  public int get(int key) {
    System.out.printf("%nget(%d)%n", key);
    Integer value = ll.remove(key);
    if (value != null)
      ll.put(key, value);
    System.out.println(ll);
    return value != null ? value : -1;
  }

  public void put(int key, int value) {
    System.out.printf("%nput(%d, %d)%n", key, value);
    Integer item = ll.remove(key);
    if (item == null && ll.size() == capacity) {
      ll.remove(ll.entrySet().iterator().next().getKey());
    }
    ll.put(key, value);
    System.out.println(ll);
  }
}
