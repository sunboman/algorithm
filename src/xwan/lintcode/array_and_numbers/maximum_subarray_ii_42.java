package xwan.lintcode.array_and_numbers;

import java.util.ArrayList;

/**
 * Created by xwan on 11/30/16.
 */
public class maximum_subarray_ii_42 {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        int size = nums.size();

        int[] leftMax = new int[size];
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);

            leftMax[i] = max;
        }

        int[] rightMax = new int[size];
        max = Integer.MIN_VALUE;
        sum = 0;

        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);

            rightMax[i] = max;
        }

        int maxSub = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            maxSub = Math.max(maxSub, (leftMax[i] + rightMax[i + 1]));
        }

        return maxSub;
    }
}
