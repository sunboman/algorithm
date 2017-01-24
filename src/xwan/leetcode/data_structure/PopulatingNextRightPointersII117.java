package xwan.leetcode.data_structure;

/**
 * Created by xwan on 12/26/16.
 */
public class PopulatingNextRightPointersII117 {
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode curr = dummy;
            while (root != null) {
                if (root.left != null) {
                    curr.next = root.left;
                    curr = curr.next;
                }
                if (root.right != null) {
                    curr.next = root.right;
                    curr = curr.next;
                }
                root = root.next;
            }
            root = dummy.next;
        }
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }
}
