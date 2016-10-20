package leetcode.Stack;

import java.util.LinkedList;

/**
 * Created by sunbo_000 on 10/19/2016.
 */
/*
    https://leetcode.com/problems/evaluate-reverse-polish-notation/
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

    Some examples:
      ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
      ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

 */
public class Evaluate_Reverse_Polish_Notation_150 {
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        for (String token : tokens) {
            Integer right;
            Integer left;
            switch (token) {
                case "+":
                    right = Integer.valueOf(stack.pop());
                    left = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(left + right));
                    break;
                case "-":
                    right = Integer.valueOf(stack.pop());
                    left = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(left - right));
                    break;
                case "*":
                    right = Integer.valueOf(stack.pop());
                    left = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(left * right));
                    break;
                case "/":
                    right = Integer.valueOf(stack.pop());
                    left = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(left / right));
                    break;
                default:
                    stack.push(token);
            }
        }

        return Integer.valueOf(stack.pop());
    }


    public static void main(String[] args) {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(new Evaluate_Reverse_Polish_Notation_150().evalRPN(tokens));
    }

}
