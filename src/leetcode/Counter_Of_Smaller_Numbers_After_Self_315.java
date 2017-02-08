package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunbo on 2/7/2017.
 */
public class Counter_Of_Smaller_Numbers_After_Self_315 {
    class Node {
        Node left, right;
        int val;
        int sum;
        int dup;

        public Node(int val, int sum) {
            this.val = val;
            this.sum = sum;
            this.dup = 1;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }
        Integer[] res = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, res, i, 0);
        }
        return Arrays.asList(res);
    }

    private Node insert(int num, Node node, Integer[] res, int index, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            res[index] = preSum;
        } else if (num == node.val) {
            node.dup++;
            res[index] = preSum + node.sum;
        } else if (num > node.val) {
            node.right = insert(num, node.right, res, index, preSum + node.sum + node.dup);
        } else {
            node.sum++;
            node.left = insert(num, node.left, res, index, preSum);
        }
        return node;
    }

    public static void main(String[] args) {
        new Counter_Of_Smaller_Numbers_After_Self_315().countSmaller(new int[]{5, 2, 6, 1});
    }
}
