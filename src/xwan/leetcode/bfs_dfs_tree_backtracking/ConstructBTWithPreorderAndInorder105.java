package xwan.leetcode.bfs_dfs_tree_backtracking;

/**
 * Created by xwan on 12/27/16.
 */
public class ConstructBTWithPreorderAndInorder105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }

        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int pos = findPos(inorder, inStart, inEnd, preorder[preStart]);

        root.left = dfs(preorder, preStart + 1, preStart + pos - inStart, inorder, inStart, pos - 1);
        root.right = dfs(preorder, preStart + pos - inStart + 1, preEnd, inorder, pos + 1, inEnd);

        return root;
    }

    private int findPos(int[] inorder, int inStart, int inEnd, int target) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
