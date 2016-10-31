/**
 * 145 Binary Tree Postorder Traversal
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.

  For example:
  Given binary tree {1,#,2,3},
     1
      \
       2
      /
     3
  return [3,2,1].

  Note: Recursive solution is trivial, could you do it iteratively?
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
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
 * @return {number[]}
 */
var postorderTraversal = function(root) {
    var result = [];
    if (root === null) {
        return result;
    }
    helper(root);
    return result;

    function helper(root) {
        if (root === null) {
            return result;
        }
        if (root.left !== null) {
            helper(root.left);
        }
        if (root.right !== null) {
            helper(root.right);
        }
        result.push(root.val);
    }
};