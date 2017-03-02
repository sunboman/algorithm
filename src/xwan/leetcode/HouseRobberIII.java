package xwan.leetcode;

/**
 * Created by xwan on 2/23/17.
 */

/**
 * 337. House Robber III
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
      3
     / \
    2   3
    \   \
    3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
      3
     / \
    4  5
   / \  \
  1  3  1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    public int rot(TreeNode root) {
        if (root == null) return 0;
        int[] max = helper(root);
        return Math.max(max[0], max[1]);
    }
    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0,0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] max = new int[2];
        max[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // exclude current
        max[1] = left[0] + right[0] + root.val; // include current
        return max;
    }
}
