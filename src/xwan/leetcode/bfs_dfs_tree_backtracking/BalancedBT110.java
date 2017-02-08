package xwan.leetcode.bfs_dfs_tree_backtracking;

import java.util.*;

/**
 * Created by xwan on 12/30/16.
 */
public class BalancedBT110 {
    private static final int UNBALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHeight(root) != UNBALANCED;
    }
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if (l == UNBALANCED || r == UNBALANCED || Math.abs(l - r) > 1) {
            return UNBALANCED;
        }
        return Math.max(l, r) + 1;
    }

    private static int sumTrees(TreeNode root, List<Integer> res) {
        if (root == null) {
            return 0;
        }
        int left = sumTrees(root.left, res);
        int right = sumTrees(root.right, res);
        int sum = root.val + left + right;
        res.add(sum);

        return sum;
    }
    private static int sumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        int sum = root.val + left + right;

        return sum;
    }
    public static int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int sum = sumTree(node);
            max = Math.max(sum, max);
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        List<Integer> tmp = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                tmp.add(key);
            }
        }
        int[] res = new int[tmp.size()];
        int idx = 0;
        for (int ele : tmp) {
            res[idx++] = ele;
        }
        return res;
    }

    private static int treeSums(TreeNode root, List<Integer> res) {
        int left = (root.left == null) ? 0 : treeSums(root.left, res);
        int right = (root.right == null) ? 0 : treeSums(root.right, res);
        int sum = left + right + root.val;
        res.add(sum);
        return sum;
    }
    static int max = 0;
    private static int helper(TreeNode n, Map<Integer, Integer> map){
        int left = (n.left==null) ? 0 : helper(n.left, map);
        int right = (n.right==null) ? 0 : helper(n.right, map);
        int sum = left + right + n.val;
        map.put(sum, map.getOrDefault(sum,0)+1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(-2);
        root.left = l;
        root.right = r;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);

//        treeSums(root, res);

//        findFrequentTreeSum(root);
    }
}
