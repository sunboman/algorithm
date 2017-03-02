package xwan.leetcode;

/**
 * Created by xwan on 2/28/17.
 */

/**
 * 43. Multiply Strings
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int factor = 1;
        int pre = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            int tmpPro = 0;
            factor = getFactor(i, num1.length() - 1);
            int x = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int prod = x * y + carry;
                tmpPro += (prod % 10) * factor;
                carry = prod / 10;
                factor *= 10;
            }
            if (carry > 0) tmpPro += carry * factor;
            pre += tmpPro;
        }
        sb.append(pre);
        return sb.toString();
    }
    private static int getFactor(int i, int n) {
        int factor = 1;
        while (i++ < n) factor *= 10;
        return factor;
    }

    public static void main(String[] args) {
        multiply("23", "456");
    }
}
