package leetcode.recursion;

/**
 * Created by sunbo_000 on 10/16/2016.
 */

import leetcode.Largest_Number_179;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 * <p>
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 * <p>
 * 10
 * / \
 * 5  15
 * / \   \
 * 1   8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 * <p>
 * <p>
 * <p>
 * Hint:
 * <p>
 * You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */

public class Largest_BST_SubTree_333 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int max_bfs(TreeNode root) {
        int[] size = {0};
        dfs(root, Long.valueOf(Integer.MAX_VALUE) + 1, Long.valueOf(Integer.MIN_VALUE) - 1, size);
        return size[0];
    }

    private int dfs(TreeNode node, long max, long min, int[] size) {
        if (node == null) return 0;
        if (node.val <= min || node.val >= max) return -1;
        int left = dfs(node.left, node.val, min, size);
        int right = dfs(node.right, max, node.val, size);
        if (left != -1 && right != -1) {
            size[0] = Math.max(size[0], left + right + 1);
            return left + right + 1;
        } else return -1;
    }

    public static void main(String[] args) {
        TreeNode eighteen = new TreeNode(18);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode eight = new TreeNode(8);
        TreeNode fifteen = new TreeNode(20);
        TreeNode seven = new TreeNode(20);
        eighteen.left = five;
        eighteen.right = fifteen;
        five.left = one;
        five.right = eight;
        fifteen.right = seven;
        Largest_BST_SubTree_333 solution = new Largest_BST_SubTree_333();
        System.out.println(solution.max_bfs(eighteen));
    }
}
