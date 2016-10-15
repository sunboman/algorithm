package leetcode.binary_search;

/**
 * Created by sunbo_000 on 10/14/2016.
 */

/*
    https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class Search_in_Rotated_Sorted_Array_33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else low = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        Search_in_Rotated_Sorted_Array_33 solution = new Search_in_Rotated_Sorted_Array_33();
        System.out.println(solution.search(nums, 3));
    }
}
