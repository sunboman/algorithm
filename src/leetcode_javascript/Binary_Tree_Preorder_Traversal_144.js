/**
 * 144 Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.

  For example:
  Given binary tree {1,#,2,3},
     1
      \
       2
      /
     3
  return [1,2,3].
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
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
var preorderTraversal = function(root) {
    var result = [];
    if (root === null) {
        return result;
    }
    var stack = [];
    stack.push(root);
    while (stack.length > 0) {
        var curr = stack.pop();
        result.push(curr.val);
        if (curr.right !== null) {
            stack.push(curr.right);
        }
        if (curr.left !== null) {
            stack.push(curr.left);
        }
    }
    return result;
};