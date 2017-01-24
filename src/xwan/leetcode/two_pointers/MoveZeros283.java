package xwan.leetcode.two_pointers;

/**
 * Created by xwan on 12/29/16.
 */
public class MoveZeros283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        int l = 0;
        int r = 1;
        while (r < n) {
            while (l < n && nums[l] != 0) {
                l++;
            }
            if (r < l) {
                r = l + 1;
            }
            while (r < n && nums[r] == 0) {
                r++;
            }

            if (r < n) {
                swap(nums, l, r);
                l++;
                r++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
