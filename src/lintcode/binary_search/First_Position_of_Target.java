package lintcode.binary_search;

/**
 * Created by bosun on 10/25/16.
 */
/*
    http://www.lintcode.com/en/problem/first-position-of-target/
    For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n)
    time complexity.

    If the target number does not exist in the array, return -1.
 */
public class First_Position_of_Target {
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
