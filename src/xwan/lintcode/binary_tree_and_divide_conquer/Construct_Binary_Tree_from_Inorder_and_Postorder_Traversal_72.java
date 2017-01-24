package xwan.lintcode.binary_tree_and_divide_conquer;

/**
 * Created by xwan on 11/1/16.
 */

/**
 *
 * 72 Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.

     Notice

     You may assume that duplicates do not exist in the tree.

     Have you met this question in a real interview? Yes
     Example
     Given inorder [1,2,3] and postorder [1,3,2], return a tree:

     2
     / \
     1   3
 *
 * http://www.lintcode.com/en/problem/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_72 {


    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder.length != postorder.length) {
            return null;
        }

        return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private int getPos(int[] inorder, int instart, int inend, int key) {
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }

        return -1;
    }

    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
                                 int[] postorder, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }

        int key = postorder[postend];

        TreeNode root = new TreeNode(key);

        int pos = getPos(inorder, instart, inend, key);

        root.left = myBuildTree(inorder, instart, pos - 1, postorder, poststart, poststart + pos - instart - 1);
        root.right = myBuildTree(inorder, pos + 1, inend, postorder, poststart + pos - instart, postend - 1);

        return root;
    }
}
