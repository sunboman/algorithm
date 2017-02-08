package xwan.bloomberg;

import java.util.Arrays;

/**
 * Created by xwan on 2/1/17.
 */

/**
 * Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number.
 * Please return the number of pairs.
 *
 * Example
     Given nums = [1,1,2,45,46,46], target = 47
     return 2

     1 + 46 = 47
     2 + 45 = 47s

 */
public class TwoSumVI {
    public static int twoSum6(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int l = 0;
        int n = nums.length;
        int r = n - 1;
        while (l < r) {
            int tmpSum = nums[l] + nums[r];
            if (tmpSum == target) {
                count++;
                l++;
                r--;
                while (l < n && nums[l] == nums[l - 1]) {
                    l++;
                }
                while (r > 0 && nums[r] == nums[r + 1]) {
                    r--;
                }
            } else if (tmpSum < target) {
                l++;
            } else {
                r--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {7,11,11,1,2,3,4};
        twoSum6(nums, 22);
    }
}
