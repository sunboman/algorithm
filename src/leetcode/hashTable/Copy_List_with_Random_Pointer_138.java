package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunbo_000 on 10/18/2016.
 */

/*
    https://leetcode.com/problems/copy-list-with-random-pointer/

    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    Return a deep copy of the list.
 */

public class Copy_List_with_Random_Pointer_138 {
    private static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode curr = newHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, new RandomListNode(head.label));
        while (head != null) {
            if (map.containsKey(head)) {
                curr.next = map.get(head);
            } else curr.next = new RandomListNode(head.label);
            RandomListNode random = head.random;
            if (random != null && !map.containsKey(random))
                map.put(random, new RandomListNode(random.label));

            curr.next.random = map.get(random);
            curr = curr.next;
            head = head.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        RandomListNode four = new RandomListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        one.random = three;
        two.random = three;
        Copy_List_with_Random_Pointer_138 solution = new Copy_List_with_Random_Pointer_138();
        RandomListNode ret = solution.copyRandomList(one);
        String stop = "";
    }
}
