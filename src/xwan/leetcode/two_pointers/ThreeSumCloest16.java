package xwan.leetcode.two_pointers;

import java.util.Arrays;

/**
 * Created by xwan on 12/30/16.
 */
public class ThreeSumCloest16 {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MIN_VALUE;
        }

        int n = nums.length;
        int result = nums[0] + nums[1] + nums[n - 1];
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r && r < n) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, -3};
        System.out.println(threeSumClosest(nums, 1));
    }
}
