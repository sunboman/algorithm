package xwan.lintcode.binary_tree_and_divide_conquer;

/**
 * Created by xwan on 10/31/16.
 */

/**
 *
 * 469 Identical Binary Tree
 *
 * Check if two binary trees are identical. Identical means the two binary trees have the same structure and every identical position has the same value.

     Have you met this question in a real interview? Yes
     Example
     1             1
     / \           / \
     2   2   and   2   2
     /             /
     4             4
     are identical.

     1             1
     / \           / \
     2   3   and   2   3
     /               \
     4                 4
     are not identical.
 *
 * http://www.lintcode.com/en/problem/identical-binary-tree/
 */
public class Identical_Binary_Tree_469 {
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
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a != null && b != null) {
            return a.val == b.val &&
                    isIdentical(a.left, b.left) &&
                    isIdentical(a.right, b.right);
        }

        return false;
    }
}
