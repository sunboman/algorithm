/**
 * 42 Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

  For example,
  Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


  The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!


 *
 * https://leetcode.com/problems/trapping-rain-water/
 */

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if(height === null || height.length < 2) return 0;
    var res = 0, left = 0, right = height.length - 1;
    while(left + 1 < right) {
        if(height[left] < height[right]) {
            if(height[left + 1] < height[left]) {
                res += height[left] - height[left + 1];
                height[left + 1] = height[left];
            }
            left++;
        } else {
            if(height[right - 1] < height[right]) {
                res += height[right] - height[right - 1];
                height[right - 1] = height[right];
            }
            right--;
        }
    }

    return res;
};