package xwan.bloomberg;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xwan on 1/25/17.
 */
public class FindFirstDuplicate {
    public static int findFirstDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int minIdx = Integer.MAX_VALUE;
        Set<Integer> hash = new HashSet<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (!hash.add(nums[i])) {
                minIdx = Math.min(minIdx, i);
            }
        }
        return nums[minIdx];
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, 2, 5, 5, 4, 3};
        System.out.println(findFirstDup(nums));
    }
}
