package xwan.linkedin;

/**
 * Created by xwan on 2/14/17.
 */

/**
 * 256. Paint House
 *
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 Example
 Given costs = [[14,2,11],[11,14,5],[14,3,10]] return 10

 house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10
 *
 */
public class PainHourse {
    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
        }

        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }

    public static void main(String[] args) {
        int[][] costs = {{14,2,11},{11,14,5},{14,3,10}};
        System.out.println(minCost(costs));
    }
}
