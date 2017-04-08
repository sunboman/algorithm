package xwan.leetcode.bfs_dfs_tree_backtracking;

import java.util.Stack;

/**
 * Created by xwan on 1/5/17.
 */

/**
 * 404. Sum of Left Leaves
 *
 * Find the sum of all left leaves in a given binary tree.

 Example:

 3
 / \
 9  20
 /  \
 15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
