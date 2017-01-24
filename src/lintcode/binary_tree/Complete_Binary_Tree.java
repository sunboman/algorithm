package lintcode.binary_tree;

/**
 * Created by bosun on 10/27/16.
 */
public class Complete_Binary_Tree {
    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // Write your code here
        return checkComplete(root).isComplete;
    }

    private TreeResult checkComplete(TreeNode node) {
        if (node == null) {
            return new TreeResult(0, true, true);
        }

        TreeResult left = checkComplete(node.left);
        TreeResult right = checkComplete(node.right);
        if (!left.isComplete) {
            return new TreeResult(-1, false, false);
        }

        if (left.depth == right.depth) {
            if (!left.isFull || !right.isComplete) {
                return new TreeResult(-1, false, false);
            }
            return new TreeResult(left.depth + 1, right.isFull, true);
        }

        if (left.depth == right.depth + 1) {
            if (!left.isComplete || !right.isFull) {
                return new TreeResult(-1, false, false);
            }
            return new TreeResult(left.depth + 1, false, true);
        }

        return new TreeResult(-1, false, false);
    }

    private static class TreeResult {
        int depth;
        boolean isFull;
        boolean isComplete;

        public TreeResult(int depth, boolean isFull, boolean isComplete) {
            this.depth = depth;
            this.isFull = isFull;
            this.isComplete = isComplete;
        }
    }


    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        one.left = two;
        one.right = three;
        three.right = four;
        System.out.println(new Complete_Binary_Tree().isComplete(one));
    }

}
