package LinkedIn;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by sunbo on 12/30/2016.
 */
/*
Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.

Example:
Given binary tree
          1
         / \
        2   3
       / \
      4   5
Returns [4, 5, 3], [2], [1].

Explanation:
1. Remove the leaves [4, 5, 3] from the tree

          1
         /
        2
2. Remove the leaf [2] from the tree

          1
3. Remove the leaf [1] from the tree

          []
Returns [4, 5, 3], [2], [1].
 */
public class Find_Leaves_Of_Binary_Tree_366 {
    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private int helper(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return - 1;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int curr = Math.max(left, right) + 1;
        if (curr >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(curr).add(root.val);
        return curr;
    }


    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        List<List<Integer>> res = new Find_Leaves_Of_Binary_Tree_366().findLeaves(one);
    }
}
