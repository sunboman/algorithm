package xwan.lintcode.data_structure;

import java.util.*;

/**
 * Created by xwan on 11/30/16.
 */
public class top_k_largest_numbers_ii_545 {
    PriorityQueue<Integer> pq;
    int maxSize;

    public top_k_largest_numbers_ii_545(int k) {
        // initialize your data structure here.
        pq = new PriorityQueue<>(k);
        maxSize = k;

    }

    public void add(int num) {
        // Write your code here
        if (pq.size() < maxSize) {
            pq.offer(num);
            return;
        }

        if (num > pq.peek()) {
            pq.poll();
            pq.offer(num);
            return;
        }
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> topKList = new ArrayList<>();
        Iterator ite = pq.iterator();
        while (ite.hasNext()) {
            topKList.add((Integer) ite.next());
        }

        Collections.sort(topKList);
        Collections.reverse(topKList);

        return topKList;
    }
}
