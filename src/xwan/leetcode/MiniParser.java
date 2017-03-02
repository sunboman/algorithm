package xwan.leetcode;

/**
 * Created by xwan on 2/26/17.
 */

import xwan.audible.IntersectionOfLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 385. Mini Parser
 *
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Note: You may assume that the string is well-formed:

 String is non-empty.
 String does not contain white spaces.
 String contains only digits 0-9, [, - ,, ].
 Example 1:

 Given s = "324",

 You should return a NestedInteger object which contains a single integer 324.
 Example 2:

 Given s = "[123,[456,[789]]]",

 Return a NestedInteger object containing a nested list with 2 elements:

 1. An integer containing value 123.
 2. A nested list containing two elements:
 i.  An integer containing value 456.
 ii. A nested list with one element:
 a. An integer containing value 789.
 */
class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;

    public NestedInteger(List<NestedInteger> list){
        this.list = list;
    }

    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public NestedInteger(Integer integer){
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList();
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public String printNi(NestedInteger thisNi, StringBuilder sb){
        if(thisNi.isInteger()) {
            sb.append(thisNi.integer);
            sb.append(",");
        }
        sb.append("[");
        for(NestedInteger ni : thisNi.list){
            if(ni.isInteger()) {
                sb.append(ni.integer);
                sb.append(",");
            }
            else {
                printNi(ni, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (s == null) return null;
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        NestedInteger res = null;
        Stack<NestedInteger> stack = new Stack<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (res != null) stack.push(res);
                res = new NestedInteger();
                l = r + 1;
            } else if (ch == ']') {
                String curr = s.substring(l, r);
                if (!curr.isEmpty()) res.add(new NestedInteger(Integer.valueOf(curr)));
                if (!stack.isEmpty()) {
                    NestedInteger top = stack.pop();
                    top.add(res);
                    res = top;
                }
                l = r + 1;
            } else if (ch == ',') {
                if (s.charAt(r - 1) != ']') {
                    String curr = s.substring(l, r);
                    res.add(new NestedInteger(Integer.valueOf(curr)));
                }
                l = r + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new MiniParser().deserialize("[123,[456,[789]]]");
    }
}
