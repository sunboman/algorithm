package xwan.leetcode.two_pointers;

/**
 * Created by xwan on 12/25/16.
 */
public class TrapingRainWater42 {
    public static int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int n = height.length;
        int water = 0;
        int left = 0;
        int right = n - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        while (left < right) {
            if (left < right && left + 1 < n && maxLeft <= maxRight) {
                if (height[left + 1] < maxLeft) {
                    water += maxLeft - height[left + 1];
                } else {
                    maxLeft = height[left + 1];
                }
                left++;
            } else if (right > left && right - 1 >= 0 && maxLeft > maxRight) {
                if (height[right - 1] < maxRight) {
                    water += maxRight - height[right - 1];
                } else {
                    maxRight = height[right - 1];
                }
                right--;
            }
        }

        return water;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(nums);
    }
}
