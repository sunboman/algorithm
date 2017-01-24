package xwan.leetcode.bfs_dfs_tree_backtracking;

import java.util.Stack;

/**
 * Created by xwan on 1/5/17.
 */
public class SumOfLeftLeaves404 {
    public int sumOfLeftLeaves_recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves_recur(root.left);
            }
        }
        sum += sumOfLeftLeaves_recur(root.right);
        return sum;
    }

    public int sumOfLeftLeaves_ite(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return sum;
    }
}
