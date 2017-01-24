package xwan.leetcode.binary_search_divide_conquer;

/**
 * Created by xwan on 12/29/16.
 */
public class SearchInRotatedSortedArray33 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target <= nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(search(nums, 3));
    }
}
