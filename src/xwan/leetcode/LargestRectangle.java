package xwan.leetcode;

import java.util.Stack;

/**
 * Created by xwan on 2/20/17.
 */

/**
 * 84. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.
 */
public class LargestRectangle {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, top * w);
                i--;
            }
        }
//        while (i < n) {
//            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
//                stack.push(i++);
//            } else {
//                int top = heights[stack.pop()];
//                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
//                maxArea = Math.max(maxArea, top * w);
//            }
//        }
//        while (!stack.isEmpty()) {
//            int top = heights[stack.pop()];
//            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
//            maxArea = Math.max(maxArea, top * w);
//        }
        System.out.println(maxArea);
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        largestRectangleArea(heights);
    }
}
