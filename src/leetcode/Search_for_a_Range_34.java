package leetcode;

import java.util.Arrays;

/**
 * Created by sunbo_000 on 10/4/2016.
 */
public class Search_for_a_Range_34 {
    public int[] searchRange(int[] nums, int target) {

        int left = -1;
        int right = -1;
        int j = Arrays.binarySearch(nums, target);
        if (j < 0) return new int[]{left, right};
        left = j - 1;
        right = j + 1;

        while (left >= 0) {
            if (Arrays.binarySearch(nums, 0, left + 1, target) < 0) break;
            left = Arrays.binarySearch(nums, 0, left + 1, target) - 1;
        }

        while (right >= 0 && right < nums.length) {
            if (Arrays.binarySearch(nums, right, nums.length, target) < 0) break;
            right = Arrays.binarySearch(nums, right, nums.length, target) + 1;
        }

        return new int[]{left + 1, right - 1};
    }


    public static void main(String[] args) {
        Search_for_a_Range_34 solution = new Search_for_a_Range_34();
        solution.searchRange(new int[]{1}, 0);
    }
}
