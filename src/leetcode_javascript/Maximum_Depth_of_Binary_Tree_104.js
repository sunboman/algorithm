/**
 *
 * 104. Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 *
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
 * @return {number}
 */
var maxDepth = function(root) {
    if(root === null) return 0;
    var left = 1,
        right = 1;

    if(root.left !== null)
        left += maxDepth(root.left);
    if(root.right !== null)
        right += maxDepth(root.right);

    return left > right ? left : right;
};