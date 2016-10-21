package leetcode.greedy;

/**
 * Created by sunbo_000 on 10/20/2016.
 */

/*
    https://leetcode.com/problems/gas-station/
    There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

    Note:
    The solution is guaranteed to be unique.
 */

public class Gas_Station_134 {

    /*
        If the car can not reach C with A-> B -> C then it cannot reach C with B -> C
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tankRem = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int rem = gas[i] - cost[i];
            if(tankRem >=0 ) tankRem += rem;
            else {
                start = i;
                tankRem = rem;
            }
            total += rem;
        }

        return total < 0 ? -1 : start;
    }


}
