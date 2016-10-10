package leetcode;

import java.util.TreeSet;

/**
 * Created by sunbo_000 on 10/5/2016.
 */
public class Contains_Duplicate_III_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = treeSet.floor(nums[i] + t);
            Integer ceil = treeSet.ceiling(nums[i] - t);
            if (floor != null && floor >= nums[i] || ceil != null && ceil <= nums[i]) return true;
            treeSet.add(nums[i]);

            if (i >= k) treeSet.remove(nums[i - k]);
        }
        return false;

    }

    public static void main(String[] args) {
        Contains_Duplicate_III_220 solution = new Contains_Duplicate_III_220();
        solution.containsNearbyAlmostDuplicate(new int[]{8,1,7},3,2);
    }
}
