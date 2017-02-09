package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sunbo on 2/9/2017.
 */
public class Skyline_218 {
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return new ArrayList<>(0);
        }
        List<int[]> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], building[2]});
            heights.add(new int[]{building[1], -building[2]});
        }
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prev = 0;
        for (int[] height : heights) {
            if (height[1] > 0) {
                pq.offer(height[1]);
            } else {
                pq.remove(-height[1]);
            }
            int curr = pq.peek();
            if (curr != prev) {
                res.add(new int[]{height[0], curr});
                prev = curr;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Skyline_218().getSkyline(new int[][]{
                {2, 9, 10}, {2, 9, 11}
        });
    }
}
