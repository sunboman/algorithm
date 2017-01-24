package xwan.leetcode.bfs_dfs_tree_backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xwan on 12/31/16.
 */
public class SerializeAndDeserializeBT297 {
    private static final String SPLITER = ",";
    private static final String NLL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NLL).append(SPLITER);
        } else {
            sb.append(root.val).append(SPLITER);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || "[]".equals(data)) {
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree(queue, 0);
    }
    private TreeNode buildTree(Queue<String> data, int idx) {
        String tmp = data.remove();
        if (NLL.equals(tmp)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(tmp));
            node.left = buildTree(data, idx + 1);
            node.right = buildTree(data, idx + 1);
            return node;
        }
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abcdse");
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString());
    }
}
