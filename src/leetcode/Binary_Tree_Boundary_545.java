package leetcode;

import java.util.*;

/**
 * Created by bosun on 3/25/17.
 */
public class Binary_Tree_Boundary_545 {
  List<Integer> leaves = new ArrayList<>();

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    if (root == null) {
      return leaves;
    }
    List<Integer> res = new ArrayList<>();
    if (root.left != null || root.right != null)
      findLeaves(root);
    res.add(root.val);
    if (root.left != null)
      res.addAll(leftBoundary(root));
    res.addAll(leaves);
    if (root.right != null)
      res.addAll(rightBoundary(root));
    return res;
  }

  private List<Integer> leftBoundary(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    while (root.left != null || root.right != null) {
      res.add(root.val);
      if (root.left != null)
        root = root.left;
      else
        root = root.right;
    }
    if (res.size() < 2) {
      return new ArrayList<>();
    }
    return res.subList(1, res.size());
  }

  private List<Integer> rightBoundary(TreeNode root) {
    LinkedList<Integer> res = new LinkedList<>();
    while (root.left != null || root.right != null) {
      res.push(root.val);
      if (root.right != null)
        root = root.right;
      else
        root = root.left;
    }
    if (res.size() < 1) {
      return new ArrayList<>();
    }
    return new ArrayList<>(res).subList(0, res.size() - 1);
  }

  private void findLeaves(TreeNode root) {
    if (root.left == null && root.right == null) {
      leaves.add(root.val);
    } else {
      if (root.left != null) findLeaves(root.left);
      if (root.right != null) findLeaves(root.right);
    }
  }
}
