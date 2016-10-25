package lintcode.binary_search;

/**
 * Created by sunbo_000 on 10/24/2016.
 */

/*
    http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.
 */

public class Find_Minimum_in_Rotated_Sorted_Array {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int left;
            if (mid - 1 < 0) {
                left = nums[nums.length - 1];
            } else {
                left = nums[mid - 1];
            }
            if (left > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid - 1;
            }
        }

        return -1;
    }
}
