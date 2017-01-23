package BloomBerg;

/**
 * Created by sunbo on 1/3/2017.
 */
public class Binary_Tree_Grandparent {
    static class TreeNode {
        TreeNode left, right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int getGrandParent(TreeNode root, TreeNode node) {
        int[] res = new int[1];
        getGrandParent(root, node, res);
        return res[0];
    }

    private int getGrandParent(TreeNode root, TreeNode node, int[] res) {
        if (root == null) {
            return 0;
        }
        if (root.val == node.val) {
            return 1;
        }
        int path = 0;
        path += getGrandParent(root.left, node, res);
        path += getGrandParent(root.right, node, res);
        if (path > 0) {
            path++;
        }
        if (path == 3) {
            res[0] = root.val;
        }
        return path;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        five.right = seven;
        three.right = six;
        seven.left = eight;
        int res = new Binary_Tree_Grandparent().getGrandParent(one, eight);
    }
}
