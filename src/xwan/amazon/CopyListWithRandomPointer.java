package xwan.amazon;

/**
 * Created by xwan on 1/27/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *  A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    class RandomListNode {
        int val;
        RandomListNode next, random;

        public RandomListNode(int val) {
            this.val = val;
        }
    }

    public RandomListNode copyRandomListNode(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.val));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
