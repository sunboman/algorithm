package xwan.leetcode.array_numbers_string;

/**
 * Created by xwan on 12/26/16.
 */
public class MissingNumber268 {
    public static int missingNUmber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int sum = 0;
        int n = nums.length;
        for (int elem : nums) {
            sum += elem;
        }

        return (n * (n + 1)) / 2 - sum;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 5, 3, 4};
        System.out.println(missingNUmber(nums));
    }
}
