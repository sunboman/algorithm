package xwan.leetcode;

/**
 * Created by xwan on 3/18/17.
 */
public class ConvertBSTToGreaterSum {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        addGreater(root);
        return root;
    }
    private void addGreater(TreeNode node) {
        if (node == null) return;
        addGreater(node.right);
        sum += node.val;
        node.val += sum - node.val;
        addGreater(node.left);
    }

    public static void main(String[] args) {
        ConvertBSTToGreaterSum bst = new ConvertBSTToGreaterSum();
        TreeNode root = bst.new TreeNode(5);
        TreeNode l = bst.new TreeNode(2);
        TreeNode r = bst.new TreeNode(13);
        TreeNode lr = bst.new TreeNode(1);

        root.left = l;
        root.right = r;

        bst.convertBST(root);
    }
}
