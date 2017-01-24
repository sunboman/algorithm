package Amazon_OA;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class Copy_List_With_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, newHead);
        copyNext(head, newHead, map);
        copyRandom(map, head);
        return newHead;
    }

    private void copyNext(RandomListNode head, RandomListNode newHead, Map<RandomListNode, RandomListNode> map) {
        RandomListNode newIt = newHead;
        RandomListNode it = head;
        while (it.next != null) {
            RandomListNode next = it.next;
            newIt.next = new RandomListNode(next.label);
            it = it.next;
            newIt = newIt.next;
            map.put(it, newIt);
        }
    }

    private void copyRandom(Map<RandomListNode, RandomListNode> map, RandomListNode head) {
        while (head != null) {
            if (head.random == null) {
                head = head.next;
                continue;
            }
            RandomListNode random = head.random;
            if (!map.containsKey(random)) {
                map.get(head).random = new RandomListNode(random.label);
            }
            map.get(head).random = map.get(random);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Copy_List_With_Random_Pointer solution = new Copy_List_With_Random_Pointer();
        RandomListNode head = new RandomListNode(-1);
        solution.copyRandomList(head);
    }
}