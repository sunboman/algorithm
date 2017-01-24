package xwan.leetcode.data_structure;

/**
 * Created by xwan on 12/26/16.
 */
public class PopulatingNextRightPointers116 {
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode node = root;
        while (node != null) {
            TreeLinkNode curr = node;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            node = node.left;
        }
    }
    public static void main(String[] args) {

    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
