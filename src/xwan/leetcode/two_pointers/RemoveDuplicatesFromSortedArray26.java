package xwan.leetcode.two_pointers;

/**
 * Created by xwan on 12/28/16.
 */
public class RemoveDuplicatesFromSortedArray26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int n = nums.length;
        int l = 1;
        int r = 1;
        while (l < n && r < n) {
            if (l == r && r < n && nums[l] != nums[l - 1]) {
                l++;
                r++;
            }
            while (r < n && nums[r] == nums[l - 1]) {
                r++;
            }
            if (l < r && r < n) {
                swap(nums, l, r);
                l++;
                r++;
            }
        }
        return l;
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int removeDup(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,2,2,2,2,3,4,5,5,6};
        removeDuplicates(nums);
    }
}
