package LinkedIn;

import java.util.List;

/**
 * Created by sunbo on 12/29/2016.
 */
/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.
Example
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1, 4 * 1 * 2 + 1 * 2 * 1 = 10)
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 42 + 63 = 27)
 */



public class Nested_List_Weight_Sum {
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

    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int res = 0;
        for (NestedInteger ni : nestedList) {
            res += dfs(ni, 1);
        }
        return res;
    }

    private int dfs(NestedInteger ni, int level) {
        if (ni.isInteger()) {
            return ni.getInteger() * level;
        }
        int res = 0;
        for (NestedInteger i : ni.getList()) {
            res += dfs(i, level + 1);
        }
        return res;
    }
}
