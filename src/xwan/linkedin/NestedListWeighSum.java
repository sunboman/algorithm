package xwan.linkedin;

/**
 * Created by xwan on 2/14/17.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

 Example 2:
 Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */

 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
 interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
 }

public class NestedListWeighSum {
     public int depthSum(List<NestedInteger> nestedIntegerList) {
         if (nestedIntegerList == null || nestedIntegerList.size() == 0) {
             return 0;
         }
         Queue<NestedInteger> queue = new LinkedList<>();
         for (NestedInteger nt : nestedIntegerList) {
             queue.add(nt);
         }
         int sum = 0;
         int dept = 1;
         while (!queue.isEmpty()) {
             int size = 0;
             int currSum = 0;
             while (size-- > 0) {
                 NestedInteger curr = queue.poll();
                 if (curr.isInteger()) {
                     currSum += curr.getInteger();
                 } else {
                     queue.addAll(curr.getList());
                 }
             }
             sum += currSum * dept;
             dept++;
         }
         return sum;
     }

     public int depthSum_rec(List<NestedInteger> nestedList) {
         if (nestedList == null || nestedList.size() == 0) {
             return 0;
         }
         return helper(nestedList, 1);
     }
     private int helper(List<NestedInteger> nestedList, int dept) {
         int res = 0;
         for (NestedInteger nt : nestedList) {
             if (nt.isInteger()) {
                 res += nt.getInteger() * dept;
             } else {
                 res += helper(nt.getList(), dept + 1);
             }
         }
         return res;
     }
}
