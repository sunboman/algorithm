package xwan.bloomberg;

/**
 * Created by xwan on 2/1/17.
 */

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

     get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
    it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem,
    when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

     Follow up:
     Could you do both operations in O(1) time complexity?

     Example:

     LFUCache cache = new LFUCache( 2 capacity

            cache.put(1, 1);
            cache.put(2, 2);
            cache.get(1);       // returns 1
            cache.put(3, 3);    // evicts key 2
            cache.get(2);       // returns -1 (not found)
            cache.get(3);       // returns 3.
            cache.put(4, 4);    // evicts key 1.
            cache.get(1);       // returns -1 (not found)
            cache.get(3);       // returns 3
            cache.get(4);       // returns 4
 */


/**
 * Two HashMaps are used, one to store <key, value> pair, another store the <key, node>.
    I use double linked list to keep the frequent of each key. In each double linked list node,
    keys with the same count are saved using java built in LinkedHashSet. This can keep the order.
    Every time, one key is referenced, first find the current node corresponding to the key,
    If the following node exist and the frequent is larger by one, add key to the keys of the following node,
    else create a new node and add it following the current node.
    All operations are guaranteed to be O(1).
 */
public class LFUCache {
    class Node {
        int count;
        LinkedHashSet<Integer> keys;
        Node pre, next;

        public Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<>();
            pre = next = null;
        }
    }

    private Node head;
    private int capacity = 0;
    private HashMap<Integer, Integer> valueHash;
    private HashMap<Integer, Node> nodeHash;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueHash = new HashMap<>();
        nodeHash = new HashMap<>();
        head = null;
    }

    public int get(int key) {
        if (valueHash.containsKey(key)) {
            increateCount(key);
            return valueHash.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (valueHash.containsKey(key)) {
            valueHash.put(key, value);
        } else {
            if (valueHash.size() < capacity) {
                valueHash.put(key, value);
            } else {
                removeOld();
                valueHash.put(key, value);
            }
            addToHead(key);
        }
        increateCount(key);
    }
    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            head.pre = node;
            head = node;
        } else {
            head.keys.add(key);
        }
        nodeHash.put(key, head);
    }
    private void removeOld() {
        if (head == null) {
            return;
        }
        int old = 0;
        for (int k : head.keys) {
            old = k;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) {
            remove(head);
        }
        nodeHash.remove(old);
        valueHash.remove(old);
    }
    private void increateCount(int key) {
        Node node = nodeHash.get(key);
        node.keys.remove(key);

        if (node.next == null) {
            node.next = new Node(node.count + 1);
            node.next.pre = node;
            node.next.keys.add(key);
        } else if (node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            Node tmp = new Node(node.count + 1);
            tmp.keys.add(key);
            tmp.pre = node;
            tmp.next = node.next;
            node.next.pre = tmp;
            node.next = tmp;
        }

        nodeHash.put(key, node.next);
        if (node.keys.size() == 0) {
            remove(node);
        }
    }

    private void remove(Node node) {
        if (node.pre == null) {
            head = node.next;
        } else {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
    }
}
