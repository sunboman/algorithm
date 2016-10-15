package leetcode.binary_search;

/**
 * Created by sunbo_000 on 10/13/2016.
 */
public class Find_Peak_Element_162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        return findPeak(nums, 0, nums.length - 1);
    }

    private int findPeak(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (mid == 0 && nums[mid] > nums[mid + 1]) return mid;
        if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) return mid;
        if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
        else if (nums[mid] < nums[mid + 1]) return findPeak(nums, mid+1, right);
        else return findPeak(nums, left, mid-1);
    }

    public static void main(String[] args) {
        Find_Peak_Element_162 solution = new Find_Peak_Element_162();
        System.out.println(solution.findPeakElement(new int[]{1, 2}));
    }
}
