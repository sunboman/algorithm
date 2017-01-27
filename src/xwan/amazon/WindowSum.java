package xwan.amazon;

/**
 * Created by xwan on 1/27/17.
 */

/**
 * Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array,
 * find the sum of the element inside the window at each moving.
 *
 * Example
     For array [1,2,7,8,5], moving window size k = 3.
     1 + 2 + 7 = 10
     2 + 7 + 8 = 17
     7 + 8 + 5 = 20
     return [10,17,20]
 */
public class WindowSum {
    public static int[] windowSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i + 1 > k) {
                sum -= nums[i - k];
            }
            if (i + 1 >= k) {
                res[idx++] = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,7,8,5};
        windowSum(nums, 3);
    }
}
