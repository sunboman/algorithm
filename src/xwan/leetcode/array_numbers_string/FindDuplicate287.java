package xwan.leetcode.array_numbers_string;

/**
 * Created by xwan on 12/27/16.
 */
public class FindDuplicate287 {
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,2,5};
        System.out.println(findDuplicate(nums)); // 2
    }
}
