package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sunbo_000 on 10/10/2016.
 */
public class Largest_Number_179 {
    public String largestNumber(int[] nums) {
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int i : nums) {
            numList.add(i);
        }
        Collections.sort(numList, (a, b) -> {
            String aStr = a.toString() + b.toString();
            String bStr = b.toString() + a.toString();
            return bStr.compareTo(aStr);
        });

        StringBuffer sb = new StringBuffer();
        numList.forEach(sb::append);
        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }

    public static void main(String[] args) {
        Largest_Number_179 solution = new Largest_Number_179();
        int[] nums = new int[]{0, 0};
        System.out.println(solution.largestNumber(nums));
    }
}
