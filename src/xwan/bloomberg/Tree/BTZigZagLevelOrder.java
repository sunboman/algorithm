package xwan.bloomberg.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xwan on 1/11/17.
 */
public class BTZigZagLevelOrder {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean zig = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> path = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (!zig) {
                    path.add(curr.val);
                } else {
                    path.add(0, curr.val);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(path);
            zig = !zig;
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder_dfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }

        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
