package LinkedIn;

import java.util.*;

public class LevelOrderTraversal {

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    int min = 0;
    int max = 0;
    public List<String> levelOrder(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<>();
        Map<TreeNode, Integer> hash = new HashMap<>();
        List<String> finalRes = new ArrayList<>();
        if (root != null) {
            hash.put(root, 0);
            build(res, root, 0, hash);
            int offset = -min;
            for (int i = 0; i < res.size(); i++) {
                List<TreeNode> row = res.get(i);
                char[] cArr = new char[max - min + 1];
                Arrays.fill(cArr, ' ');
                StringBuilder sb = new StringBuilder(new String(cArr));
                for (int j = 0; j < row.size(); j++) {
                    TreeNode node = row.get(j);
                    int index = hash.get(node);
                    sb.setCharAt(offset + index, (char) (node.val + '0'));
                }
                finalRes.add(sb.toString());
                sb.setLength(0);
            }
        }
        return finalRes;
    }


    public void build(List<List<TreeNode>> res, TreeNode node, int height, Map<TreeNode, Integer> hash) {
        if (node == null) {
            return;
        }
        //check the list which is built on the height for each level
        if (res.size() - 1 < height) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(node);
        if (node.left != null) {
            hash.put(node.left, hash.get(node) - 1);
            build(res, node.left, height + 1, hash);
            min = Math.min(min, hash.get(node) - 1);
        }
        if (node.right != null) {
            hash.put(node.right, hash.get(node) + 1);
            build(res, node.right, height + 1, hash);
            max = Math.max(max, hash.get(node) + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        two.right = four;
        three.left = five;
        List<String> res = new LevelOrderTraversal().levelOrder(one);
    }
}