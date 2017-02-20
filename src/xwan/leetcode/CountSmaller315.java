package xwan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 2/13/17.
 */

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 Return the array [2, 1, 1, 0].
 */
public class CountSmaller315 {
    class Node {
        int val, count, dup;
        Node left, right;
        public Node(int val, int count) {
            this.val = val;
            this.count = count;
            dup = 1;
            left = right = null;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int[] temp = new int[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], temp, 0, i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : temp) {
            res.add(i);
        }
        return res;
    }

    private Node insert(Node root, int value, int[] res, int preSum, int idx) {
        if (root == null) {
            root = new Node(value, 0);
            res[idx] = preSum;
        } else if (root.val == value) {
            root.dup++;
            res[idx] = preSum + root.count;
        } else if (root.val > value) {
            root.count++;
            root.left = insert(root.left, value, res, preSum, idx);
        } else {
            root.right = insert(root.right, value, res, preSum + root.count + root.dup, idx);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        new CountSmaller315().countSmaller(nums);
    }
}
