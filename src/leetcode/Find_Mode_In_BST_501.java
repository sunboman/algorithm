package leetcode;

public class Find_Mode_In_BST_501 {
    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    int maxCount = 0;
    int maxNum = 0;
    int currVal = 0;
    int currCount = 0;
    int i = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        getMostCount(root);
        currCount = 0;
        int[] res = new int[maxNum];
        getResult(root, res);
        return res;
    }

    private void getMostCount(TreeNode root) {
        if (root == null) {
            return;
        }
        getMostCount(root.left);
        int curr = root.val;
        if (curr == currVal) {
            currCount++;
        } else {
            currVal = curr;
            currCount = 1;
        }
        if (currCount > maxCount) {
            maxCount = currCount;
            maxNum = 1;
        } else if (currCount == maxCount) {
            maxNum++;
        }
        getMostCount(root.right);
    }

    private void getResult(TreeNode root, int[] res) {
        if (root == null) {
            return;
        }
        getResult(root.left, res);
        int curr = root.val;
        if (curr == currVal) {
            currCount++;
        } else {
            currVal = curr;
            currCount = 1;
        }
        if (currCount == maxCount) {
            res[i++] = currVal;
        }
        getResult(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2);
        two.left = new TreeNode(1);
        new Find_Mode_In_BST_501().findMode(two);
    }
}