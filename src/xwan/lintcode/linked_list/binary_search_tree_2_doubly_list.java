package xwan.lintcode.linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */
public class binary_search_tree_2_doubly_list {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public static class DoublyListNode {
        int val;
        DoublyListNode next, prev;
        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }

    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public static DoublyListNode bstToDoublyList(TreeNode root) {
        // Write your code here
        List<Integer> list = inorderTraversal(root);

        if (list == null || list.size() == 0) {
            return null;
        }

        DoublyListNode head = new DoublyListNode(list.get(0));
        DoublyListNode temp = head;

        for (int i = 1; i < list.size(); i++) {
            DoublyListNode next = new DoublyListNode(list.get(i));
            temp.next = next;
            next.prev = temp;
            temp = temp.next;
        }

        return head;
    }
    
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            
            TreeNode curr = stack.pop();
            res.add(curr.val);
            temp = curr.right;
        }
        
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(5);
        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(3);
        l.left = ll;
        l.right = lr;
        root.left = l;
        root.right = r;

        List<Integer> list = inorderTraversal(root);

        DoublyListNode head = bstToDoublyList(root);

        System.out.println(head);
    }
}