package xwan.lintcode.binary_tree_and_divide_conquer;

/**
 * Created by xwan on 10/31/16.
 */

/**
 *
 * 470 Tweaked Identical Binary Tree
 *
 * Check two given binary trees are identical or not. Assuming any number of tweaks are allowed. A tweak is defined as a swap of the children of one node in the tree.

     Notice

     There is no two nodes with the same value in the tree.

     Have you met this question in a real interview? Yes
     Example
     1             1
     / \           / \
     2   3   and   3   2
     /                   \
     4                     4
     are identical.

     1             1
     / \           / \
     2   3   and   3   2
     /             /
     4             4
     are not identical.
 *
 *
 * http://www.lintcode.com/en/problem/tweaked-identical-binary-tree/
 */
public class Tweaked_Identical_Binary_Tree_470 {

    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    /**
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a ==  null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        if (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)) {
            return true;
        }
        if (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left)) {
            return true;
        }
        return false;
    }
}
