package xwan.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xwan on 2/18/17.
 */
public class RelativeRanks {
    public static String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        Integer[] sorts = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorts[i] = i;
        }
        Arrays.sort(sorts, (b, a) -> nums[b] - nums[a]);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[sorts[i]] = "Gold Medal";
            } else if (i == 1) {
                res[sorts[i]] = "Silver Medal";
            } else if (i == 2) {
                res[sorts[i]] = "Bronze Medal";
            } else {
                res[sorts[i]] = String.valueOf(i + 1);
            }
        }
        Collections.reverse(Arrays.asList(res));
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        findRelativeRanks(nums);
    }
}
