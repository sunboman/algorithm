package leetcode;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    Map<Integer, Node> nodeMap;
    Map<Integer, Integer> valueMap;
    Node tail;
    int capacity;

    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        valueMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (valueMap.containsKey(key)) {
            addFreq(key);
            return valueMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (valueMap.containsKey(key)) {
            addFreq(key);
        } else {
            if (valueMap.size() < capacity) {
                addFreq(key);
            } else {
                removeOld();
                addFreq(key);
            }
        }
        valueMap.put(key, value);
    }

    private void removeOld() {
        if (tail == null) {
            return;
        }
        int oldKey = -1;
        for (int i : tail.keys) {
            oldKey = i;
            break;
        }
        tail.keys.remove(oldKey);
        if (tail.keys.size() == 0) {
            removeNode(tail);
        }
        nodeMap.remove(oldKey);
        valueMap.remove(oldKey);
    }

    private void removeNode(Node node) {
        if (node.next == null) {
            tail = node.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
    }

    private void addFreq(int key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.keys.remove(key);
            if (node.prev != null && node.prev.freq == node.freq + 1) {
                node.prev.keys.add(key);
                nodeMap.put(key, node.prev);
            } else {
                Node newNode = new Node();
                newNode.freq = node.freq + 1;
                newNode.keys = new LinkedHashSet<>();
                newNode.keys.add(key);
                if (node.prev == null) {
                    node.prev = newNode;
                    newNode.next = node;
                } else {
                    node.prev.next = newNode;
                    node.prev = newNode;
                    newNode.prev = node.prev;
                    newNode.next = node;
                }
                nodeMap.put(key, newNode);
            }
            if (node.keys.size() == 0) {
                removeNode(node);
            }
        } else {
            if (tail == null || tail.freq > 1) {
                Node node = new Node();
                node.freq = 1;
                node.keys = new LinkedHashSet<>();
                node.keys.add(key);
                if (tail == null) {
                    tail = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
                nodeMap.put(key, node);
            } else {
                tail.keys.add(key);
                nodeMap.put(key, tail);
            }
        }
    }

    private class Node {
        Node prev, next;
        int freq;
        LinkedHashSet<Integer> keys;

        Node() {

        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.put(3, 3);
        lfuCache.put(4, 4);
        lfuCache.get(4);
        lfuCache.get(3);
        lfuCache.get(2);
        lfuCache.get(1);
        lfuCache.put(5, 5);
        lfuCache.get(1);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.get(4);
        lfuCache.get(5);
    }
}