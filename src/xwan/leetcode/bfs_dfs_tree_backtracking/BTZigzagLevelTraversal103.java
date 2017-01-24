package xwan.leetcode.bfs_dfs_tree_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xwan on 12/28/16.
 */
public class BTZigzagLevelTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean zig = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> path = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (zig) {
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
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(0, 2);
    }
}
