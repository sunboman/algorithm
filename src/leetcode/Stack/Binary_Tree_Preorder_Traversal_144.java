package leetcode.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunbo_000 on 10/19/2016.
 */
/*
    https://leetcode.com/problems/binary-tree-preorder-traversal/
    Given a binary tree, return the preorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,2,3].

    Note: Recursive solution is trivial, could you do it iteratively?
 */

/**
 * Use Stack: root->right->left
 */
public class Binary_Tree_Preorder_Traversal_144 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return ret;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        three.right = two;
        three.left = one;
        List<Integer> result = new Binary_Tree_Preorder_Traversal_144().preorderTraversal(three);
        String stop = "";
    }
}
