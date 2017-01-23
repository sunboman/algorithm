package BloomBerg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunbo on 1/4/2017.
 */
public class BST_TWO_SUM {
    private static class TreeNode{
        TreeNode left, right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<TreeNode> solutionII(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        LinkedList<TreeNode> leftStack = new LinkedList<>();
        LinkedList<TreeNode> rightStack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null) {
            leftStack.push(curr);
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rightStack.push(curr);
            curr = curr.right;
        }
        while (leftStack.peek() != rightStack.peek()) {
            TreeNode left = leftStack.peek();
            TreeNode right = rightStack.peek();
            int sum = left.val + right.val;
            if (sum == target) {
                return Arrays.asList(left, right);
            } else if (sum > target) {
                TreeNode temp = right.left;
                rightStack.pop();
                while (temp != null) {
                    rightStack.push(temp);
                    temp = temp.right;
                }
            } else {
                TreeNode temp = left.right;
                leftStack.pop();
                while (temp != null) {
                    leftStack.push(temp);
                    temp = temp.left;
                }
            }
        }
        return new ArrayList<>(0);
    }

    public List<TreeNode> solution(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        int remain = target - root.val;
        TreeNode leftRes = helper(root.left, remain);
        TreeNode rightRes = helper(root.right, remain);
        if (leftRes != null) {
            return Arrays.asList(root, leftRes);
        }
        if (rightRes != null) {
            return Arrays.asList(root, rightRes);
        }
        List<TreeNode> leftSol = solution(root.left, target);
        List<TreeNode> rightSol = solution(root.right, target);
        if (leftSol != null && leftSol.size() > 0) {
            return leftSol;
        } else {
            return rightSol;
        }
    }

    private TreeNode helper(TreeNode node, int target) {
        if (node == null) {
            return null;
        }
        if (target == node.val) {
            return node;
        } else if(target > node.val) {
            return helper(node.right, target);
        } else {
            return helper(node.left, target);
        }
    }

    public static void main(String[] args) {
        TreeNode eight = new TreeNode(8);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode ten = new TreeNode(10);
        TreeNode nine = new TreeNode(9);
        TreeNode ele = new TreeNode(11);
        eight.left = four;
        eight.right = ten;
        four.left = three;
        four.right = six;
        ten.left = nine;
        ten.right = ele;
        List<TreeNode> list = new BST_TWO_SUM().solutionII(eight, 10);
    }
}
