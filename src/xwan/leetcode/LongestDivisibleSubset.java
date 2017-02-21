package xwan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xwan on 2/20/17.
 */

/**
 * 368. Largest Divisible Subset
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 nums: [1,2,3]

 Result: [1,2] (of course, [1,3] will also be ok)
 Example 2:

 nums: [1,2,4,8]

 Result: [1,2,4,8]
 */
public class LongestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null) return new ArrayList<>();
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        int max = 0;
        int lastIdx = -1;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && (count[j] + 1 > count[i])) {
                    count[i] = count[j] + 1;
                    pre[i] = j;
                }
            }
            if (max < count[i]) {
                count[i] = max;
                lastIdx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (lastIdx != -1) {
            res.add(nums[lastIdx]);
            lastIdx = pre[lastIdx];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,16,8};
        largestDivisibleSubset(nums);
    }
}
