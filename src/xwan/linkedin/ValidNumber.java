package xwan.linkedin;


/**
 * Created by xwan on 2/16/17.
 */

/**
 * 65. Valid Number
 *
 * Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
public class ValidNumber {
    public static boolean isValid(String s) {
        s = s.trim();

        boolean numberSeen = false;
        boolean numberAfterE = true;
        boolean dotSeen = false;
        boolean eSeen = false;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                numberSeen = true;
                numberAfterE = true;
            } else if (ch == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (ch == 'e' || ch == 'E') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterE = false;
            } else if (ch == '-' || ch == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        return numberSeen && numberAfterE;
    }
    public static void main(String[] args) {
        System.out.println(isValid("1"));
        System.out.println(isValid(".2"));
        System.out.println(isValid("01.2"));
        System.out.println(isValid(" e 1"));
        System.out.println(isValid(" 2e10"));
    }
}
