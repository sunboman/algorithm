package xwan.leetcode;

/**
 * Created by xwan on 2/11/17.
 */
public class MajorityNumber {
    public static int findmajorIdx(int[] nums) {
        int pos = majorNum(nums);
        if (isMajor(nums, nums[pos])) {
            return pos;
        }
        return -1;
    }
    private static int majorNum(int[] nums) {
        int count = 1;
        int major = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[major] == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                count = 1;
                major = i;
            }
        }

        return major;
    }

    private static boolean isMajor(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        if (count >= nums.length / 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,3,2,3,-3,2,4,5,6,7,6};
        System.out.println(findmajorIdx(nums));
    }
}
