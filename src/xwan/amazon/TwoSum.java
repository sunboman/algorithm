package xwan.amazon;

/**
 * Created by xwan on 1/26/17.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 Please note that your returned answers (both index1 and index2) are NOT zero-based.

 Example
     numbers=[2, 7, 11, 15], target=9

     return [1, 2]


 2. Given an array of integers, find how many pairs in the array such that their sum is equal to a specific target number.
 Please return the number of pairs.

 Example
 Given numbers = [2, 7, 11, 15], target = 9. Return 1. (2 + 7 is the only pair)

 3. Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number.
 Please return the number of pairs.

 Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)

 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
        }

        return new int[]{-1, -1};
    }


    // count two sum equal to target
    public static int countPair(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int currSum = nums[l] + nums[r];
            if (currSum == target) {
                count++;
                l++;
                r--;
            } else if (currSum < target) {
                l++;
            } else {
                r--;
            }
        }
        return count;
    }


    // count two sum greater than target
    public static int countGreaterPair(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int countPair = 0;
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (l < r && nums[l] + nums[r] > target) {
                countPair += r - l;
                r--;
            } else {
                l++;
            }
        }
        return countPair;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 3, 11, 5, 6, 4};
//        twoSum(nums, 10);
//        System.out.println(countPair(nums, 9));
        System.out.println(countGreaterPair(nums, 11));
    }
}
