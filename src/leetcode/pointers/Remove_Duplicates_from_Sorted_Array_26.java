package leetcode.pointers;

/**
 * Created by sunbo_000 on 10/18/2016.
 */
public class Remove_Duplicates_from_Sorted_Array_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        Remove_Duplicates_from_Sorted_Array_26 solution = new Remove_Duplicates_from_Sorted_Array_26();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2}));
    }
}
