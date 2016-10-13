package leetcode.hashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo_000 on 10/12/2016.
 */
public class Permutations_46 {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> numsList = new ArrayList<Integer>();

        if (nums == null) {
            return result;
        } else {
            // convert int[] to List<Integer>
            for (int item : nums) numsList.add(item);
        }

        if (nums.length <= 1) {
            result.add(numsList);
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] numsNew = new int[nums.length - 1];
            System.arraycopy(nums, 0, numsNew, 0, i);
            System.arraycopy(nums, i + 1, numsNew, i, nums.length - i - 1);

            List<List<Integer>> resTemp = permute(numsNew);
            for (List<Integer> temp : resTemp) {
                temp.add(nums[i]);
                result.add(temp);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations_46 solution = new Permutations_46();
        List<List<Integer>> result = solution.permute(nums);
        String a= "";
    }
}
