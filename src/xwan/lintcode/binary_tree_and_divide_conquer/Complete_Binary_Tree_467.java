package xwan.lintcode.binary_tree_and_divide_conquer;

/**
 * Created by xwan on 10/31/16.
 */

/**
 *
 *  Complete Binary Tree
 *
 *  Check a binary tree is completed or not. A complete binary tree is a binary tree that every level is completed filled except the deepest level. In the deepest level, all nodes must be as left as possible. See more definition

     Have you met this question in a real interview? Yes
     Example
     1
     / \
     2   3
     /
     4
     is a complete binary.

     1
     / \
     2   3
     \
     4
     is not a complete binary.

 * http://www.lintcode.com/en/problem/complete-binary-tree/
 */
class ResultType {
    int depth;
    boolean isComplete, isFull;
    public ResultType(int depth, boolean isFull, boolean isComplete) {
        this.depth = depth;
        this.isComplete = isComplete;
        this.isFull = isFull;
    }
}
public class Complete_Binary_Tree_467 {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */


    /**
     * Definition of TreeNode:
     *
     */
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public boolean isComplete(TreeNode root) {
        ResultType res = helper(root);

        return res.isComplete;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        if (!left.isComplete) {
            return new ResultType(-1, false, false);
        }
        // left.depth = right.depth, left should be full, and right should be complete
        if (left.depth == right.depth) {
            if (!left.isFull || !right.isComplete) {
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, right.isFull, true);
        }
        // left.depth = right.depth + 1, left should be complete, right should be full
        if (left.depth == right.depth + 1) {
            if (!left.isComplete || !right.isFull) {
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, false, true);
        }

        return new ResultType(-1, false, false);
    }
}
