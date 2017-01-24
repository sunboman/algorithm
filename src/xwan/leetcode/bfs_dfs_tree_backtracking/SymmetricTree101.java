package xwan.leetcode.bfs_dfs_tree_backtracking;

/**
 * Created by xwan on 12/30/16.
 */
public class SymmetricTree101 {
    // solution with recursive
    public static boolean isSymmetric_recur(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }
    private static boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
