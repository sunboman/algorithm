package xwan.bloomberg.Tree;

/**
 * Created by xwan on 1/12/17.
 */

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 */
public class BTUpsideDown {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode upsideDown(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode newRoot = upsideDown(left);
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;

        return newRoot;
    }

    // solution with iterative
    public static TreeNode upsideDown_ite(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode res = null;
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode left = null;
        while (curr != null) {
            next = curr.left;
            curr.left = left;
            left = curr.right;
            curr.right = res;
            res = curr;
            curr = next;
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode test = buildTree();
//        TreeNode ans = upsideDown(test);
        TreeNode res = upsideDown_ite(test);
    }

    private static TreeNode buildTree() {
        TreeNode test = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(7);
        TreeNode lll = new TreeNode(8);
        TreeNode llr = new TreeNode(9);
        test.left = l;
        test.right = r;
        l.left = ll;
        l.right = lr;
        ll.left = lll;
        ll.right = llr;
//        r.left = rl;
//        r.right = rr;

        return test;
    }
}
