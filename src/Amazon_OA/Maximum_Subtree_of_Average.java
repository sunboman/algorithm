package Amazon_OA;

import java.util.ArrayList;

/**
 * Created by sunbo on 11/28/2016.
 */

/*
就是给一棵多叉树，表示公司内部的上下级关系。每个节点表示一个员工，节点包含的成员是他工作了几个月(int)，以及一个下属数组(ArrayList<Node>)。
目标就是找到一棵子树，满足：这棵子树所有节点的工作月数的平均数是所有子树中最大的。最后返回这棵子树的根节点。这题补充一点，返回的不能是叶子节
点(因为叶子节点没有下属)，一定要是一个有子节点的节点。

 class Node {
    int val;
    ArrayList<Node> children;
 }
然后函数是传入一整棵树的根节点，输出符合要求的子树根节点。
 */
class ReturnType {
    Node root;
    int num;
    double avg;


    public ReturnType(Node root, int num, double avg) {
        this.root = root;
        this.num = num;
        this.avg = avg;
    }
}

class SumCount {
    int sum;
    int count;

    public SumCount(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}

class Node {
    int val;
    ArrayList<Node> children;

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class Maximum_Subtree_of_Average {

    public static Node solution(Node root) {
        ReturnType max = new ReturnType(null, 0, 0.0);
        myDfs(root, max);
        return max.root;
    }

    private static ReturnType myDfs(Node root, ReturnType max) {
        if (root.children == null || root.children.size() == 0) {
            return new ReturnType(root, 1, root.val);
        }
        ArrayList<Node> children = root.children;
        int num = 1;
        double total = root.val;
        for (Node node : children) {
            ReturnType returnType = myDfs(node, max);
            num += returnType.num;
            total += (returnType.avg * returnType.num);
        }
        double avg = total / num;
        ReturnType rt = new ReturnType(root, num, avg);
        if (avg > max.avg) {
            max.root = root;
            max.avg = avg;
        }
        return rt;
    }

    //两个全局变量用来找最小的平均值,和对应的节点
    private static double resAve = Double.MIN_VALUE;
    private static Node result;

    public static Node getHighAve(Node root) {
        if (root == null) return null;
        dfs(root);
        return result;
    }

    //后序遍历递归。
    private static SumCount dfs(Node root) {
        // 这里必须先把叶子节点刨掉，注意看我的手法，其实没什么。
        if (root.children == null || root.children.size() == 0) {
            return new SumCount(root.val, 1);
        }
        //把当前root的材料都准备好
        int curSum = root.val;
        int curCnt = 1;
        //注意了这里开始遍历小朋友了
        for (Node child : root.children) {
            SumCount cSC = dfs(child);
            //每次遍历一个都把sum,count都加上，更新
            curSum += cSC.sum;
            curCnt += cSC.count;
        }
        double curAve = (double) curSum / curCnt;
        //这里看一下最大值要不要更新
        if (resAve < curAve) {
            resAve = curAve;
            result = root;
        }

        return new SumCount(curSum, curCnt);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        Node res = getHighAve(root);
        Node myRes = solution(root);
        System.out.println(res.val + " " + resAve);
    }
}


