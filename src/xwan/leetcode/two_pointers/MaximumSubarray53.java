package xwan.leetcode.two_pointers;

/**
 * Created by xwan on 12/26/16.
 */
public class MaximumSubarray53 {
    public static int maxSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = nums[0];
        int tempMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            tempMax = Math.max(tempMax + nums[i], nums[i]);
            max = Math.max(max, tempMax);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
