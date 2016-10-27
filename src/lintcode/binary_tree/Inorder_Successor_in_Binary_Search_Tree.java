package lintcode.binary_tree;

import java.util.LinkedList;

/**
 * Created by bosun on 10/26/16.
 */
public class Inorder_Successor_in_Binary_Search_Tree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }
        TreeNode[] next = new TreeNode[1];
        TreeNode node = dfs(root, p, next);

        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return prev(node.right);
        }

        if (next[0] == null) {
            return node.right;
        } else {
            return next[0];
        }
    }

    private TreeNode prev(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode[] next) {
        if (node == null) {
            return null;
        }

        if (node.val == p.val) {
            return node;
        } else if (node.val < p.val) {
            return dfs(node.right, p, next);
        } else {
            next[0] = node;
            return dfs(node.left, p, next);
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        three.left = one;
        three.right = four;
        one.right = two;
        TreeNode result = new Inorder_Successor_in_Binary_Search_Tree().inorderSuccessor(three, new TreeNode(2));
        String stop = "";
    }
}
