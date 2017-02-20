package xwan.lintcode;

import java.util.Arrays;

/**
 * Created by xwan on 2/13/17.
 */
public class RemoveDup {
    public int deduplication(int[] nums) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return nums.length;
        }
        Arrays.sort(nums);
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == nums[left - 1]) {
                swap(nums, left, right);
                left++;
                right--;
                while (left <= right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else {
                left++;
            }
        }
        return left;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        new RemoveDup().deduplication(nums);
    }
}
