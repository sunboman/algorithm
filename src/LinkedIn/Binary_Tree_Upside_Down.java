package LinkedIn;

import java.util.LinkedList;

/**
 * Created by sunbo on 1/11/2017.
 */
/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node)
or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5

return the root of the binary tree [4,5,2,#,#,3,1].
  4
 / \
5   2
   / \
  3   1
 */
public class Binary_Tree_Upside_Down {
    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public TreeNode upsideDown(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null) {
            return root;
        }
        TreeNode res = upsideDown(left);
        root.left = null;
        root.right = null;
        left.left = right;
        left.right = root;
        return res;
    }
    public TreeNode upsideDownII(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode res = stack.peek();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            node.left = null;
            node.right = null;
            if (!stack.isEmpty()) {
                node.left = stack.peek().right;
                node.right = stack.peek();
            }
        }
        return res;
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
        TreeNode res = new Binary_Tree_Upside_Down().upsideDownII(one);
    }
}
