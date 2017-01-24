package xwan.bloomberg;

/**
 * Created by xwan on 1/18/17.
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int water = 0;
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        while (l < r) {
            if (leftMax <= rightMax) {
                if (l > 0 && height[l] < leftMax) {
                    water += leftMax - height[l];
                } else {
                    leftMax = height[l];
                }
                l++;
            } else {
                if (r < n - 1 && height[r] < rightMax) {
                    water += rightMax - height[r];
                } else {
                    rightMax = height[r];
                }
                r--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height = {};
    }
}
