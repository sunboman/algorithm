package xwan.lintcode.binary_tree_and_divide_conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 2/5/17.
 */

/**
 * Your are given a binary tree in which each node contains a value. Design an algorithm to get all paths which sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go in a straight line down.
 *
 *
 * Example
     Given a binary tree:

      1
     / \
    2  3
   /  /
  4  2
     for target = 6, return

     [
     [2, 4],
     [1, 3, 2]
     ]

 */
public class BTPathSum246 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, target, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private void helper(TreeNode root, int target, List<Integer> tmp, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        int sum = 0;
        tmp.add(root.val);
        for (int i = level; i >= 0; i--) {
            sum += tmp.get(i);
            if (sum == target) {
                List<Integer> path = new ArrayList<>();
                for (int j = i; j <= level; j++) {
                    path.add(tmp.get(j));
                }
                res.add(path);
            }
        }
        helper(root.left, target, tmp, res, level + 1);
        helper(root.right, target, tmp, res, level + 1);
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args) {
        BTPathSum246 bt = new BTPathSum246();
        TreeNode root = bt.new TreeNode(1);
        TreeNode l = bt.new TreeNode(2);
        TreeNode r = bt.new TreeNode(3);
        TreeNode ll = bt.new TreeNode(4);
        TreeNode rl = bt.new TreeNode(2);
        root.left = l;
        root.right = r;
        l.left = ll;
        r.left = rl;

        bt.binaryTreePathSum2(root, 6);
    }
}
