package LinkedIn;

import java.util.*;

/**
 * Created by sunbo on 12/29/2016.
 */
/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up.
 i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 */


public class Nested_List_Weight_Sum_II {
    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    int maxLayer = 1;
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (NestedInteger ni : nestedList) {
            dfs(ni, 1, map);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += (maxLayer + 1 - entry.getKey()) * entry.getValue();
        }
        return res;
    }
    private void dfs(NestedInteger ni, int level, Map<Integer, Integer> map) {
        if (ni.isInteger()) {
            if (map.get(level) == null) {
                map.put(level, ni.getInteger());
            } else {
                map.put(level, map.get(level) + ni.getInteger());
            }
            maxLayer = Math.max(level, maxLayer);
            return;
        }
        for (NestedInteger n : ni.getList()) {
            dfs(n, level + 1, map);
        }
    }
}
