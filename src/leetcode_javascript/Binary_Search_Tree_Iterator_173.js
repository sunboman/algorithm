/**
 * 173 Binary Search Tree Iterator
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

  Calling next() will return the next smallest number in the BST.

  Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/**
 * Definition for binary tree
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @constructor
 * @param {TreeNode} root - root of the binary search tree
 */
var BSTIterator = function(root) {
    this.stack = [];
    this.curr = root;
};


/**
 * @this BSTIterator
 * @returns {boolean} - whether we have a next smallest number
 */
BSTIterator.prototype.hasNext = function() {
    return this.curr !== null || this.stack.length;
};

/**
 * @this BSTIterator
 * @returns {number} - the next smallest number
 */
BSTIterator.prototype.next = function() {
    while (this.curr !== null) {
        this.stack.push(this.curr);
        this.curr = this.curr.left;
    }
    this.curr = this.stack.pop();
    var node = this.curr;
    this.curr = this.curr.right;
    return node.val;
};

/**
 * Your BSTIterator will be called like this:
 * var i = new BSTIterator(root), a = [];
 * while (i.hasNext()) a.push(i.next());
*/