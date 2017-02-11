package xwan.leetcode.binary_search_divide_conquer;

/**
 * Created by xwan on 2/10/17.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 436. Find Right Interval
 *
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

 For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

 Note:
 You may assume the interval's end point is always bigger than its start point.
 You may assume none of these intervals have the same start point.
 Example 1:
 Input: [ [1,2] ]

 Output: [-1]

 Explanation: There is only one interval in the collection, so it outputs -1.
 Example 2:
 Input: [ [3,4], [2,3], [1,2] ]

 Output: [-1, 0, 1]

 Explanation: There is no satisfied "right" interval for [3,4].
 For [2,3], the interval [3,4] has minimum-"right" start point;
 For [1,2], the interval [2,3] has minimum-"right" start point.
 Example 3:
 Input: [ [1,4], [2,3], [3,4] ]

 Output: [-1, 2, -1]

 Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 For [2,3], the interval [3,4] has minimum-"right" start point.
 */
public class FindRightInterval {
    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            int start = intervals[i].start;
            map.put(start, i);
            starts[i] = start;
        }
        Arrays.sort(starts);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int end = intervals[i].end;
            int start = binarySearch(starts, intervals[i].end);
            if (start < end) {
                res[i] = -1;
            } else {
                res[i] = map.get(start);
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (nums[lo] < target) {
            return nums[hi];
        } else {
            return nums[lo];
        }
    }
}
