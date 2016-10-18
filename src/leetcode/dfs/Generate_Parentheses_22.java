package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo_000 on 10/3/2016.
 */
public class Generate_Parentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) return result;
        dfs(result,new StringBuilder(),n,n);
        return result;
    }

    void dfs(List<String> result,StringBuilder str,int left, int right) {
        if(left > right) return;
        StringBuilder sbLeft = new StringBuilder(str);
        StringBuilder sbRight = new StringBuilder(str);
        if(left == 0 && right == 0) {
            result.add(str.toString());
            return;
        }

        if(left>0) dfs(result,sbLeft.append("("),left-1,right);
        if(right>0) dfs(result,sbRight.append(")"),left,right-1);
    }
    public static void main(String[] args) {
        Generate_Parentheses_22 solution = new Generate_Parentheses_22();
        solution.generateParenthesis(0);
        solution.generateParenthesis(1);
        solution.generateParenthesis(2);
        solution.generateParenthesis(3);
    }
}
