package xwan.lintcode.array_and_numbers;

/**
 * Created by xwan on 11/29/16.
 */
public class maximum_product_subarray_191 {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public static int maxProduct(int[] nums) {
        // write your code here
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];

        max[0] = min[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            max[i] = min[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }

            res = Math.max(res, max[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};

        int res = maxProduct(nums);

        System.out.println(res);
    }
}
