package leetcode.recursion;

/**
 * Created by sunbo_000 on 10/15/2016.
 */

/*
    https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class Binary_Tree_Maximum_Path_Sum_124 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        rec(root, max);
        return max[0];
    }

    private int rec(TreeNode node, int[] max) {

        if (node == null) return 0;


        int left = rec(node.left, max);
        int right = rec(node.right, max);

        int arch = left + node.val + right;

        int maxToParent = Math.max(node.val, Math.max(left, right) + node.val);
        int maxPath = Math.max(arch, maxToParent);
        max[0] = Math.max(max[0], maxPath);
        return maxToParent;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(1);
        TreeNode three = new TreeNode(1);
        Binary_Tree_Maximum_Path_Sum_124 solution = new Binary_Tree_Maximum_Path_Sum_124();
        System.out.println(solution.maxPathSum(one));
        one.left = two;
        one.right = three;
        System.out.println(solution.maxPathSum(one));
    }
}
