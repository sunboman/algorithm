package leetcode.bfs;

import java.util.*;

/**
 * Created by sunbo_000 on 10/18/2016.
 */

/*
    https://leetcode.com/problems/clone-graph/
 */
/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */

public class Clone_Graph_133 {

    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, newNode);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            List<UndirectedGraphNode> neighbors = curr.neighbors;
            for (UndirectedGraphNode neighbor : neighbors) {
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode neighbor_copy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, neighbor_copy);
                    map.get(curr).neighbors.add(neighbor_copy);
                    queue.add(neighbor);
                } else map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        UndirectedGraphNode two = new UndirectedGraphNode(2);
        UndirectedGraphNode three = new UndirectedGraphNode(3);
        UndirectedGraphNode four = new UndirectedGraphNode(4);
        one.neighbors.add(two);
        one.neighbors.add(three);
        two.neighbors.add(one);
        two.neighbors.add(three);
        two.neighbors.add(four);
        three.neighbors.add(one);
        three.neighbors.add(two);
        three.neighbors.add(four);
        four.neighbors.add(two);
        four.neighbors.add(three);

        Clone_Graph_133 solution = new Clone_Graph_133();
        solution.cloneGraph(one);
    }
}
