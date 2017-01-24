package xwan.leetcode.data_structure;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwan on 12/26/16.
 */
public class LRUCache146 {
    int capacity;
    Map<Integer, DoubleLinkedList> map;
    DoubleLinkedList head;
    DoubleLinkedList tail;
    public LRUCache146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            remove(node);
            setHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            remove(node);
            node.val = value;
            setHead(node);
        } else {
            DoubleLinkedList newNode = new DoubleLinkedList(key, value);
            if (map.size() < capacity) {
                setHead(newNode);
            } else {
                map.remove(tail.key);
                remove(tail);
                setHead(newNode);
            }
            map.put(key, newNode);
        }
    }

    private void setHead(DoubleLinkedList node) {
        node.pre = null;
        node.next = head;
        if (head != null) {
            head.pre = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    private void remove(DoubleLinkedList node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    class DoubleLinkedList {
        int key;
        int val;
        DoubleLinkedList pre;
        DoubleLinkedList next;

        public DoubleLinkedList(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }
}
