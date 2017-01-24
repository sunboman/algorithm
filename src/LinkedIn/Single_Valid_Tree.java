package LinkedIn;

import java.util.*;

/**
 * Created by sunbo on 1/8/2017.
 */
public class Single_Valid_Tree {
    private static class TreeNode {
        TreeNode left, right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean isValid(List<TreeNode> nodes) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                if (map.containsKey(node.left)) {
                    return false;
                }
                map.put(node.left, node);
            }
            if (node.right != null) {
                if (map.containsKey(node.right)) {
                    return false;
                }
                map.put(node.right, node);
            }
        }
        TreeNode root = findRoot(nodes.get(0), map);
        if (root == null) {
            return false;
        }
        for (TreeNode node : nodes) {
            if (findRoot(node, map) != root) {
                return false;
            }
        }
        return true;
    }

    private TreeNode findRoot(TreeNode node, Map<TreeNode, TreeNode> map) {
        TreeNode res = node;
        Set<TreeNode> path = new HashSet<>();
        while (map.containsKey(res)) {
            if (!path.add(res)) {
                return null;
            }
            TreeNode parent = map.get(res);
            if (map.containsKey(parent)) {
                map.put(res, map.get(parent));
            }
            res = parent;
        }
        return res;
    }

    public boolean isValidII(List<TreeNode> nodes) {
        Set<TreeNode> childrenSet = new HashSet<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                if (!childrenSet.add(node.left)) {
                    return false;
                }
            }
            if (node.right != null) {
                if (!childrenSet.add(node.right)) {
                    return false;
                }
            }
        }
        TreeNode root = null;
        int count = 0;
        for (TreeNode node : nodes) {
            if (!childrenSet.contains(node)) {
                count++;
                root = node;
            }
        }
        if (count != 1) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    childrenSet.remove(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    childrenSet.remove(node.right);
                }
            }
        }
        return childrenSet.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
//        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        two.left = one;

        List<TreeNode> list = Arrays.asList(four, one, two, three);
        new Single_Valid_Tree().isValid(list);
    }
}
