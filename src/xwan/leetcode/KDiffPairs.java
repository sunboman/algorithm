package xwan.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xwan on 3/4/17.
 */
public class KDiffPairs {
    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) return 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if (set.contains(num) && !visited.contains(num)) {
                count++;
                visited.add(num);
                if (set.contains(num + k)) visited.add(num + k);
                if (set.contains(num - k)) visited.add(num - k);
            }
            set.add(num - k);
            set.add(num + k);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,1};
        findPairs(nums, 1);
    }
}
