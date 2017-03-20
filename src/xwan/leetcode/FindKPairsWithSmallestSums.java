package xwan.leetcode;

/**
 * Created by xwan on 3/3/17.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:
 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 Example 2:
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 Example 3:
 Given nums1 = [1,2], nums2 = [3],  k = 3

 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]
 */
public class FindKPairsWithSmallestSums {
    class Pair {
        int[] pair;
        int num1;
        int num2;
        int sum;
        int idx;
        public Pair(int num1, int num2, int idx) {
            pair = new int[]{num1, num2};
            sum = num1 + num2;
            this.num1 = num1;
            this.num2 = num2;
            this.idx = idx;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        int n = nums1.length;
        int m = nums2.length;
        for (int i = 0; i < n && i < k; i++) {
            pq.offer(new Pair(nums1[i], nums2[0], 0));
        }
        while (k-- > 0 && !pq.isEmpty()) {
            Pair curr = pq.poll();
            res.add(curr.pair);
            if (curr.idx == m - 1) continue;
            pq.offer(new Pair(curr.num1, nums2[curr.idx + 1], curr.idx + 1));
        }
        return res;
    }
}
