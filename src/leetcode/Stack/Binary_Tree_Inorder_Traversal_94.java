package leetcode.Stack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunbo_000 on 10/19/2016.
 */
/*
    https://leetcode.com/problems/binary-tree-inorder-traversal/
    Given a binary tree, return the inorder traversal of its nodes' values.

    For example:
    Given binary tree [1,null,2,3],
       1
        \
         2
        /
       3
    return [1,3,2].

    Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Inorder_Traversal_94 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (list.contains(node)) {
                ret.add(node.val);
                continue;
            }
            if (node.right != null) stack.push(node.right);
            stack.push(node);
            if (node.left != null) stack.push(node.left);
            list.add(node);
        }

        return ret;
    }

    public List<Integer> inorderTraversal_2nc(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                ret.add(node.val);
                curr = node.right;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        one.right = three;
        one.left = two;
        two.right = five;
        three.left = four;
        three.right = six;
       /* one.right = two;
        two.left = three;*/
        List<Integer> res = new Binary_Tree_Inorder_Traversal_94().inorderTraversal_2nc(one);
        String stop = "";
    }
}
