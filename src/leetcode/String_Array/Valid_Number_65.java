package leetcode.String_Array;

/**
 * Created by sunbo_000 on 10/20/2016.
 */
/*
    https://leetcode.com/problems/valid-number/
    Validate if a given string is numeric.

    Some examples:
    "0" => true
    " 0.1 " => true
    "abc" => false
    "1 a" => false
    "2e10" => true
    Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
public class Valid_Number_65 {
    public boolean isNumber(String s) {
        int i = 0;
        String str = s.trim();
        int length = str.length();
        boolean isNumeric = false;
        if (i < length && (str.charAt(i) == '+' || str.charAt(i) == '-')) i++;
        while (i < length && Character.isDigit(str.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < length && str.charAt(i) == '.') {
            i++;
            while (i < length && Character.isDigit(str.charAt(i))) {
                isNumeric = true;
                i++;
            }
        }
        if (i < length && isNumeric && (str.charAt(i) == 'e' || str.charAt(i) == 'E')) {
            i++;
            isNumeric = false;
            if (i < length && (str.charAt(i) == '+' || str.charAt(i) == '-')) i++;
            while (i < length && Character.isDigit(str.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }

        return isNumeric && i == length;
    }

    public static void main(String[] args) {
        Valid_Number_65 solution = new Valid_Number_65();
        System.out.println(solution.isNumber("3"));
    }
}
