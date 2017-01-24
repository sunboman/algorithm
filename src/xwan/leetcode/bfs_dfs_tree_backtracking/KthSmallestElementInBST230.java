package xwan.leetcode.bfs_dfs_tree_backtracking;

import java.util.Stack;

/**
 * Created by xwan on 12/31/16.
 */
public class KthSmallestElementInBST230 {
    // dfs iterative
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (k != 0) {
            TreeNode curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            TreeNode node = curr.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return -1;
    }
}
