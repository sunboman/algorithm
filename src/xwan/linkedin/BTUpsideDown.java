package xwan.linkedin;

/**
 * Created by xwan on 2/14/17.
 */

/**
 * 156. Binary Tree Upside Down
 *
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
      1
     / \
    2  3
   / \
  4  5
 return the root of the binary tree [4,5,2,#,#,3,1].
      4
     / \
    5  2
      / \
     3  1

 */
public class BTUpsideDown {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode upsideDownBT(TreeNode root) {
        return helper(root);
    }
    private TreeNode helper(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = helper(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return newRoot;
    }

    public TreeNode upsideDownBT_ite(TreeNode root) {
        TreeNode curr = root;
        TreeNode pre = null;
        TreeNode next = null;
        TreeNode tmp = null;
        while (curr != null) {
            next = curr.left;

            curr.left = tmp;
            tmp = curr.right;
            curr.right = pre;

            pre = curr;

            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        BTUpsideDown bt = new BTUpsideDown();
        TreeNode root = bt.new TreeNode(1);
        TreeNode l = bt.new TreeNode(2);
        TreeNode r = bt.new TreeNode(3);
        TreeNode ll = bt.new TreeNode(4);
        TreeNode lr = bt.new TreeNode(5);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;

        bt.upsideDownBT_ite(root);
    }
}
