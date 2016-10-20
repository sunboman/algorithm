/**
 *
 * 94 Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
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
var inorderTraversal = function(root) {
    var result = [];
    var stack = [];
    var temp = root;
    while(stack.length > 0 || temp !== null) {
        if(temp !== null) {
            stack.push(temp);
            temp = temp.left;
        } else {
            var currNode = stack.pop();
            result.push(currNode.val);
            temp = currNode.right;
        }
    }
    return result;
};

