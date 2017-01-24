package xwan.lintcode.binary_tree_and_divide_conquer;

/**
 * Created by xwan on 10/30/16.
 */

/**
 *  Lowest Common Ancestor II
 *
 *  Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

     The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

     The node has an extra attribute parent which point to the father of itself. The root's parent is null.
 *
 * Example
     For the following binary tree:

     4
     / \
     3   7
     / \
     5   6
     LCA(3, 5) = 4

     LCA(5, 6) = 7

     LCA(6, 7) = 7
 *
 * http://www.lintcode.com/en/problem/lowest-common-ancestor-ii/
 */

import java.util.ArrayList;

/**
 * Definition of ParentTreeNode:
 *
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Lowest_Common_Ancestor_II_474 {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */

    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
        public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                     ParentTreeNode A,
                                                     ParentTreeNode B) {
            // Write your code here
            if (root == null) {
                return null;
            }

            ArrayList<ParentTreeNode> path2RootA = getPath2Root(A);
            ArrayList<ParentTreeNode> path2RootB = getPath2Root(B);

            int idxA = path2RootA.size() - 1;
            int idxB = path2RootB.size() - 1;

            ParentTreeNode ancestor = null;

            while (idxA >= 0 && idxB >= 0) {
                if (path2RootA.get(idxA) != path2RootB.get(idxB)) {
                    break;
                }

                ancestor = path2RootA.get(idxA);
                idxA--;
                idxB--;
            }

            return ancestor;
        }

        private ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node) {
            ArrayList<ParentTreeNode> path = new ArrayList<>();
            while (node != null) {
                path.add(node);
                node = node.parent;
            }
            return path;
        }
    }
}
