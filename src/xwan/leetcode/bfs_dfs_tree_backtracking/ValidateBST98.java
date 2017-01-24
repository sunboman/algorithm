package xwan.leetcode.bfs_dfs_tree_backtracking;

import java.util.Stack;

/**
 * Created by xwan on 12/27/16.
 */
public class ValidateBST98 {
    // solution with dfs
    public static boolean isValidBST_dfs(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        return root.val < maxValue && root.val > minValue &&
                dfs(root.left, minValue, root.val) &&
                dfs(root.right, root.val, maxValue);
    }

    // solution with iterative, based on inorder traversal BST
    public static boolean isValidBST_ite(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                if (pre != null && pre.val >= pop.val) {
                    return false;
                }
                pre = pop;
                curr = pop.right;
            }
        }
        return true;
    }

}
