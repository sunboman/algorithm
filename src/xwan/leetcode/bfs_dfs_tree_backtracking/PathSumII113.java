package xwan.leetcode.bfs_dfs_tree_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 12/30/16.
 */
public class PathSumII113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        helper(root, path, res, sum);
        return res;
    }

    private void helper(TreeNode root, List<Integer> path, List<List<Integer>> res, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        } else {
            helper(root.left, path, res, sum - root.val);
            helper(root.right, path, res, sum - root.val);
        }
        path.remove(path.size() - 1); // backtracking
    }
}
