package leetcode.Stack;

import java.util.LinkedList;

/**
 * Created by sunbo_000 on 10/19/2016.
 */

/*
    https://leetcode.com/problems/trapping-rain-water/
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

    For example,
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 */

public class Trapping_Rain_Water_42 {
    /*
        Used stack to track decrease
     */
    public int trap_stack(int[] height) {
        if (height.length <= 2) return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        int water = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[stack.peek()]) {
                int temp = height[stack.pop()];
                while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                    water += (height[stack.peek()] - temp) * (i - stack.peek() - 1);
                    temp = height[stack.pop()];
                }
                if (!stack.isEmpty()) water += (height[i] - temp) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return water;
    }


    /*
        Used two pointers to point to max left and max right of each element
     */
    public int trap_twoPointer(int[] height) {
        if (height.length < 3) return 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int water = 0;
        for (int i = 1; i < height.length; i++) maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        for (int j = height.length - 2; j >= 0; j--) {
            maxRight[j] = Math.max(maxRight[j + 1], height[j + 1]);
            int minHeight = Math.min(maxLeft[j], maxRight[j]);
            if(minHeight > height[j]) water+= minHeight - height[j];
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(new Trapping_Rain_Water_42().trap_twoPointer(new int[]{4, 2, 1, 0, 3, 4}));
    }
}
