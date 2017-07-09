import java.util.LinkedList;

/**
 * Created by bosun on 4/5/17.
 */
/*
Given an expression string array, return the final result of this expression

 Notice

The expression contains only integer, +, -, *, /, (, ).

Have you met this question in a real interview? Yes
Example
For the expression 2*6-(23+7)/(1+2),
input is

[
  "2", "*", "6", "-", "(",
  "23", "+", "7", ")", "/",
  
  (", "1", "+", "2", ")"
],
return 2
 */
public class Expression_Evaluation {
  public int evaluateExpression(String[] expression) {
    // write your code here
    if (expression == null || expression.length == 0) {
      return 0;
    }
    LinkedList<Integer> values = new LinkedList<>();
    LinkedList<String> ops = new LinkedList<>();
    int n = expression.length;
    for (int i = 0; i < n; i++) {
      String str = expression[i];
      if (str.equals("(")) {
        ops.push(str);
      } else if (str.equals(")")) {
        while (!ops.peek().equals("(")) {
          values.push(calculate(values.pop(), values.pop(), ops.pop()));
        }
        ops.pop();
      } else if (str.equals("+") || str.equals("-") ||
              str.equals("*") || str.equals("/")) {
        while (!ops.isEmpty() && compareOps(str, ops.peek())) {
          values.push(calculate(values.pop(), values.pop(), ops.pop()));
        }
        ops.push(str);
      } else {
        values.push(Integer.parseInt(str));
      }
    }
    while (!ops.isEmpty()) {
      values.push(calculate(values.pop(), values.pop(), ops.pop()));
    }
    return values.pop();
  }

  private boolean compareOps(String op1, String op2) {
    if (op2.equals("(") || op2.equals(")")) {
      return false;
    } else if ((op2.equals("+") || op2.equals("-"))
            && (op1.equals("*") || op1.equals("/"))) {
      return false;
    } else {
      return true;
    }
  }

  private int calculate(int b, int a, String op) {
    switch (op) {
      case "+":
        return a + b;
      case "-":
        return a - b;
      case "*":
        return a * b;
      case "/":
        return a / b;
    }
    throw new UnsupportedOperationException("unsupported operation");
  }

  public static void main(String[] args) {
    int res = new Expression_Evaluation().evaluateExpression(new String[]{
            "2", "*", "6", "-", "(",
            "23", "+", "7", ")", "/",
            "(", "1", "+", "2", ")"
    });
  }
}
