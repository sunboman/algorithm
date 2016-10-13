package leetcode;

/**
 * Created by sunbo_000 on 10/12/2016.
 */
public class Validate_Binary_Search_Tree_98 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validateNode(root, Long.valueOf(Integer.MIN_VALUE) - 1, Long.valueOf(Integer.MAX_VALUE) + 1);
    }

    private boolean validateNode(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return validateNode(node.left, min, node.val) && validateNode(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Validate_Binary_Search_Tree_98 solution = new Validate_Binary_Search_Tree_98();
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode fifteen = new TreeNode(15);
        TreeNode six = new TreeNode(6);
        TreeNode twenty = new TreeNode(20);
        ten.left = five;
        ten.right = fifteen;
        fifteen.left = six;
        fifteen.right = twenty;

        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        two.left = one;
        two.right = three;

        TreeNode node = new TreeNode(2147483647);
        System.out.println(solution.isValidBST(two));
    }
}
