package leetcode.pointers;

/**
 * Created by sunbo_000 on 10/19/2016.
 */

/*
    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

    Follow up for "Remove Duplicates":
    What if duplicates are allowed at most twice?

    For example,
    Given sorted array nums = [1,1,1,2,2,3],

    Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */

public class Remove_Duplicates_from_Sorted_Array_II_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int n = 1;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] == nums[i]) {
                if (n == 2) continue;
                n++;
            } else n = 1;
            nums[++j] = nums[i];
        }

        return j + 1;
    }

    public static void main(String[] args) {
        Remove_Duplicates_from_Sorted_Array_II_80 solution = new Remove_Duplicates_from_Sorted_Array_II_80();
        solution.removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 3});
    }
}
