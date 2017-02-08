package xwan.audible;

/**
 * Created by xwan on 2/3/17.
 */
public class IsBST {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isBinarySearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean helper(TreeNode root, long maxValue, long minValue) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }
        return helper(root.left, root.val, minValue) && helper(root.right, maxValue, root.val);
    }
}
