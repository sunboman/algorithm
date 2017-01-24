package xwan.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwan on 12/29/16.
 */
public class CopyListwithRandomPointer138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode result = new RandomListNode(0);
        RandomListNode curr = result;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, new RandomListNode(head.label));
        while (head != null) {
            if (map.containsKey(head)) {
                curr.next = map.get(head);
            } else {
                curr.next = new RandomListNode(head.label);
            }

            if (head.random == null) {
                curr.next.random = null;
            } else {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.label));
                }
                curr.next.random = map.get(head.random);
            }

            curr = curr.next;
            head = head.next;
        }

        return result.next;
    }

    private class RandomListNode {
        int label;
        RandomListNode random;
        RandomListNode next;

        public RandomListNode(int label) {
            this.label = label;
        }
    }
}
