package leetcode.String_Array;

/**
 * Created by sunbo_000 on 10/20/2016.
 */

/*
    https://leetcode.com/problems/first-missing-positive/
    Given an unsorted integer array, find the first missing positive integer.

    For example,
    Given [1,2,0] return 3,
    and [3,4,-1,1] return 2.

    Your algorithm should run in O(n) time and uses constant space.
 */

public class First_Missing_Positive_41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                //except for non positive integers
                if (nums[i] <= 0 || nums[i] >= nums.length) break;
                //break duplicates
                if (nums[i] == nums[nums[i] - 1]) break;
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        First_Missing_Positive_41 solution = new First_Missing_Positive_41();
//        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
//        System.out.println(solution.firstMissingPositive(new int[]{4,1,2,4,3,5}));
    }
}
