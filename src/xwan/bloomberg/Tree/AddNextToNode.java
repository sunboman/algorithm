package xwan.bloomberg.Tree;

/**
 * Created by xwan on 1/13/17.
 */
public class AddNextToNode {
    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        public TreeLinkNode (int val) {
            this.val = val;
        }
    }

    public static void addNext(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode curr = root;
        while (curr != null) {
            TreeLinkNode left = curr.left;
        }
    }
}
