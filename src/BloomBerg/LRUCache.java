package BloomBerg;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    Map<Integer, DLNode> map;
    DLNode head, tail;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            setHead(map.get(key));
            return map.get(key).value;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DLNode node = map.get(key);
            node.value = value;
            setHead(node);
        } else {
            if (map.size() >= capacity) {
                if (tail != null)
                    map.remove(tail.key);
                removeTail();
            }
            DLNode node = new DLNode(key, value);
            setHead(node);
            map.put(key, node);
        }
    }
    
    private void setHead(DLNode node) {
        if (node == head) {
            return;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            DLNode prev = node.prev;
            DLNode next = node.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    
    private void removeTail() {
        if (tail == null) {
            return;
        } else {
            DLNode prev = tail.prev;
            if (prev != null) {
                prev.next = null;
            }
            tail = prev;
        }
    }
    
    class DLNode {
        DLNode prev, next;
        int key;
        int value;
        public DLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(1, 1);
        lruCache.get(2);
        lruCache.set(4, 1);
        lruCache.get(1);
        lruCache.get(2);
    }
}