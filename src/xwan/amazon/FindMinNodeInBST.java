package xwan.amazon;

/**
 * Created by xwan on 1/26/17.
 */
public class FindMinNodeInBST {
    static class Node  {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (node.val >= data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    public static int getMin(Node root) {
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.val;
    }

    public static void main(String[] args) {
        FindMinNodeInBST tree = new FindMinNodeInBST();
        Node root = null;
        root = tree.insert(root, 5);
        tree.insert(root, 2);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 6);
        tree.insert(root, 8);
        tree.insert(root, 12);

        System.out.println(getMin(root));
    }
}
