package xwan.lintcode.binary_tree_and_divide_conquer;

/**
 * Created by xwan on 11/1/16.
 */

/**
 * 73 Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.

     Notice

     You may assume that duplicates do not exist in the tree.

     Have you met this question in a real interview? Yes
     Example
     Given in-order [1,2,3] and pre-order [2,1,3], return a tree:

     2
     / \
     1   3
 *
 * http://www.lintcode.com/en/problem/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Construct_BinaryTree_from_Preorder_and_Inorder_Traversal_73 {

    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder.length != inorder.length) {
            return null;
        }

        return myBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private int getPos(int[] inorder, int instart, int inend, int key) {
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode myBuildTree(int[] preorder, int prestart, int preend,
                                 int[] inorder, int instart, int inend) {
        if (instart > inend) {
            return null;
        }

        int key = preorder[prestart];

        TreeNode root = new TreeNode(key);

        int pos = getPos(inorder, instart, inend, key);

        root.left = myBuildTree(preorder, prestart + 1, prestart + pos - instart, inorder, instart, pos - 1);
        root.right = myBuildTree(preorder, prestart + pos - instart + 1, preend, inorder, pos + 1, inend);

        return root;
    }
}
