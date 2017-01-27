package xwan.amazon;

/**
 * Created by xwan on 1/26/17.
 */

/**
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 * Example
     Given a binary tree:

          1
        /   \
     -5     2
     / \   /  \
    0   2 -4  -5

     return the node 1.
 */
public class MinimumSubTree {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private static TreeNode subTree = null;
    private static int minSum = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);
        return subTree;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currSum = root.val + helper(root.left) + helper(root.right);
        if (currSum < minSum) {
            minSum = currSum;
            subTree = root;
        }

        return currSum;
    }

    public static void main(String[] args) {

    }
}
