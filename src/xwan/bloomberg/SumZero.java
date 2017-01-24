package xwan.bloomberg;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwan on 1/5/17.
 */
public class SumZero {
    public static int sumZeroarray(int[] nums) {
        int n = nums.length, max = 0;

        // accumulate the nums
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 0 || map.containsKey(num))
                sum++;
            else
                map.put(num, i);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,0,1,2, 0, 1, -1};
        System.out.println(sumZeroarray(nums));

        System.out.println("absc".substring(0, 2));
    }
}
