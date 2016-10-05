import java.util.Arrays;

/**
 * Created by sunbo_000 on 10/4/2016.
 */
public class Next_Permutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int j = nums.length - 2;
        while (j >= 0 && (nums[j] >= nums[j + 1])) j--;
        if (j < 0) {
            Arrays.sort(nums);
            return;
        }

        int tmp = nums[j];
        for (int i = nums.length - 1; i > j; i--) {
            if(tmp < nums[i]) {
                nums[j] = nums[i];
                nums[i] = tmp;
                break;
            }
        }
        Arrays.sort(nums,j+1,nums.length);

    }

    public static void main(String[] args) {
        Next_Permutation_31 solution = new Next_Permutation_31();
        solution.nextPermutation(new int[]{1,3,2});
    }
}
