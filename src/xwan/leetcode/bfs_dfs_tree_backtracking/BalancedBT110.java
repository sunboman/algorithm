package xwan.leetcode.bfs_dfs_tree_backtracking;

/**
 * Created by xwan on 12/30/16.
 */
public class BalancedBT110 {
    private static final int UNBALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHeight(root) != UNBALANCED;
    }
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if (l == UNBALANCED || r == UNBALANCED || Math.abs(l - r) > 1) {
            return UNBALANCED;
        }
        return Math.max(l, r) + 1;
    }
}
