package leetcode.recursion;

/**
 * Created by sunbo_000 on 10/15/2016.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        if (left != null) return left;
        else return right;
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
        Lowest_Common_Ancestor_of_a_Binary_Tree_236 solution = new Lowest_Common_Ancestor_of_a_Binary_Tree_236();
        System.out.println(solution.lowestCommonAncestor(one,three,four).val);
//        System.out.println(solution.lowestCommonAncestor(one,three,two).val);
//        System.out.println(solution.lowestCommonAncestor(one,five,four).val);
    }
}
