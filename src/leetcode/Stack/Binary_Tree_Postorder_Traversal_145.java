package leetcode.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunbo_000 on 10/19/2016.
 */

/*
    https://leetcode.com/problems/binary-tree-postorder-traversal/

    Given a binary tree, return the postorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [3,2,1].

    Note: Recursive solution is trivial, could you do it iteratively?

 */
public class Binary_Tree_Postorder_Traversal_145 {
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
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        Collections.reverse(ret);
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
        /*one.right = two;
        two.left = three;*/
        List<Integer> res = new Binary_Tree_Postorder_Traversal_145().inorderTraversal(one);
        String stop = "";
    }
}
