package xwan.lintcode.binary_tree_and_divide_conquer;

/**
 * Created by xwan on 10/31/16.
 */

import java.util.ArrayList;

/**
 *
 * 11 Search Range in Binary Search Tree
 *
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

     Have you met this question in a real interview? Yes
     Example
     If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

     20
     /  \
     8   22
     / \
     4   12

 *
 * http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/
 */
public class Search_Range_in_Binary_Search_Tree_11 {

    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    ArrayList<Integer> result;
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        // ArrayList<Integer> result = new ArrayList<>();
        // if (root == null || k2 < k1) {
        //     return result;
        // }

        // helper(root, result, k1, k2);

        // Collections.sort(result);
        // return result;


        result = new ArrayList<>();
        helper2(root, k1, k2);
        return result;
    }
    private void helper2(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val > k1) {
            helper2(root.left, k1, k2);
        }
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        if (root.val < k2) {
            helper2(root.right, k1, k2);
        }
    }


    // private void helper(TreeNode root, ArrayList<Integer> res, int k1, int k2) {
    //     if (root == null) {
    //         return;
    //     }
    //     if (root.val >= k1 && root.val <= k2) {
    //         res.add(root.val);
    //     }
    //     if (root.left != null) {
    //         helper(root.left, res, k1, k2);
    //     }
    //     if (root.right != null) {
    //         helper(root.right, res, k1, k2);
    //     }
    // }


}
