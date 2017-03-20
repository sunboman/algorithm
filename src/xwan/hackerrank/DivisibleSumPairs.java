package xwan.hackerrank;

/**
 * Created by xwan on 3/19/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Divisible Sum Pairs
 *
 * https://www.hackerrank.com/challenges/divisible-sum-pairs
 */
public class DivisibleSumPairs {
    public static int sumPairs(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] %= k;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int diff = (k - num) % k;
            int count = map.getOrDefault(diff, 0);
            if (count != 0) res += count;

            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,6,1,2};
        System.out.println(sumPairs(nums, 3));
    }
}
