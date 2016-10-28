/**
 * 110 Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.

  For this problem, a height-balanced binary tree is defined as a binary tree in
  which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 * https://leetcode.com/problems/balanced-binary-tree/
 */

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function(root) {
    if (root === null) {
      return true;
    }
    return maxDepth(root) !== -1;

    function maxDepth(root) {
      if (root === null) {
        return 0;
      }
      var left = maxDepth(root.left);
      var right = maxDepth(root.right);
      if (left === -1 || right === -1 || Math.abs(left - right) > 1) {
        return -1;
      }
      return Math.max(left, right) + 1;
    }
};