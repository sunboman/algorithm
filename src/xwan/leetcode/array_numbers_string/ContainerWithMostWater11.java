package xwan.leetcode.array_numbers_string;

/**
 * Created by xwan on 12/30/16.
 */
public class ContainerWithMostWater11 {
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int n = height.length;
        int max = 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 3, 4, 6, 2, 5, 8};
        System.out.println(maxArea(height)); // 18
    }
}
