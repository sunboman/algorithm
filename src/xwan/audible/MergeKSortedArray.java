package xwan.audible;

/**
 * Created by xwan on 2/3/17.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given k sorted integer arrays, merge them into one sorted array.
 *
 * Example
 * Given 3 sorted arrays:
 *
 * [
     [1, 3, 5, 7],
     [2, 4, 6],
     [0, 8, 9, 10, 11]
   ]

     return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

 */
public class MergeKSortedArray {
    class Element {
        int val;
        int col;
        int row;

        public Element(int val, int col, int row) {
            this.val = val;
            this.col = col;
            this.row = row;
        }
    }
    public List<Integer> mergeKSortedArray(int[][] arrays) {
        List<Integer> res = new ArrayList<>();
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return res;
        }
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int n = arrays.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new Element(arrays[i][0], 0, i));
        }
        while (!pq.isEmpty()) {
            Element curr = pq.poll();
            res.add(curr.val);
            if (curr.col + 1 < arrays[curr.row].length) {
                curr.col += 1;
                curr.val = arrays[curr.row][curr.col];
                pq.offer(curr);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 5, 7}, {2, 4, 6}, {0, 8, 9, 10, 11}};
        MergeKSortedArray m = new MergeKSortedArray();
        m.mergeKSortedArray(nums);
    }

}
