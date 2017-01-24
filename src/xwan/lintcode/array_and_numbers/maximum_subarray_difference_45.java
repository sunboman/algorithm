package xwan.lintcode.array_and_numbers;

/**
 * Created by xwan on 11/30/16.
 */
public class maximum_subarray_difference_45 {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public static int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] leftMax = new int[n];
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);

            leftMax[i] = max;
        }

        int[] rightMax = new int[n];
        sum = 0;
        max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);

            rightMax[i] = max;
        }

        int[] leftMin = new int[n];
        int minSum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minSum += nums[i];
            minSum = Math.min(minSum, nums[i]);
            min = Math.min(min, minSum);

            leftMin[i] = min;
        }

        int[] rightMin = new int[n];
        minSum = 0;
        min = Integer.MAX_VALUE;

        for (int i = n - 1; i>= 0; i--) {
            minSum += nums[i];
            minSum = Math.min(minSum, nums[i]);
            min = Math.min(min, minSum);

            rightMin[i] = min;
        }

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(leftMax[i] - rightMin[i + 1]));
            maxDiff = Math.max(maxDiff, Math.abs(leftMin[i] - rightMax[i + 1]));
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -3, 1};

        System.out.print(maxDiffSubArrays(nums));
    }
}
