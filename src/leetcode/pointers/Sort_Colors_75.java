package leetcode.pointers;

/**
 * Created by sunbo_000 on 10/18/2016.
 */

/*
    https://leetcode.com/problems/sort-colors/
    Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    Note:
    You are not suppose to use the library's sort function for this problem.

 */

public class Sort_Colors_75 {
    public void sortColors(int[] nums) {
        int[] countArray = new int[3];
        for (int num : nums) countArray[num]++;
        int i = 0;
        int j = 0;
        while (j <= 2) {
            if (countArray[j] > 0) {
                nums[i++] = j;
                countArray[j]--;
            } else j++;
        }
    }

    public static void main(String[] args) {
        Sort_Colors_75 solution = new Sort_Colors_75();
        int[] nums = {0, 1, 2, 0, 1, 2, 2};
        solution.sortColors(nums);
        String a = "";
    }
}
