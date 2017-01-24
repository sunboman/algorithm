package xwan.lintcode.binary_tree_and_divide_conquer;

/**
 * Created by xwan on 10/31/16.
 */

/**
 *
 * 70 Binary Tree Level Order Traversal II
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

     Have you met this question in a real interview? Yes
     Example
     Given binary tree {3,9,20,#,#,15,7},

     3
     / \
     9  20
     /  \
     15   7


     return its bottom-up level order traversal as:

     [
     [15,7],
     [9,20],
     [3]
     ]

 *
 * http://www.lintcode.com/en/problem/binary-tree-level-order-traversal-ii/
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Binary_Tree_Level_Order_Traversal_II_70 {

    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            results.add(temp);
        }
        Collections.reverse(results);
        return results;
    }

}
