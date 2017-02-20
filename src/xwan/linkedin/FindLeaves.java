package xwan.linkedin;

/**
 * Created by xwan on 2/14/17.
 */

import xwan.amazon.FindMinNodeInBST;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:Given binary tree

     1
    / \
   2  3
  / \
 4  5
 Returns [4, 5, 3], [2], [1].

 Explanation:

 Removing the leaves [4, 5, 3] would result in this tree:
 1
 /
 2
 Now removing the leaf [2] would result in this tree:
 1
 Now removing the leaf [1] would result in the empty tree:
 []
 Returns [4, 5, 3], [2], [1].
 */
public class FindLeaves {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }
    private int helper(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return -1;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int curr = Math.max(left, right) + 1;
        if (res.size() == curr) {
            res.add(new ArrayList<>());
        }
        res.get(curr).add(root.val);
        return curr;
    }

    public static void main(String[] args) {
        FindLeaves fl = new FindLeaves();
        TreeNode root = fl.new TreeNode(1);
        TreeNode l = fl.new TreeNode(2);
        TreeNode r = fl.new TreeNode(3);
        TreeNode ll = fl.new TreeNode(4);
        TreeNode lr = fl.new TreeNode(5);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;

        fl.findLeaves(root);

    }

}
