package xwan.leetcode.array_numbers_string;

/**
 * Created by xwan on 12/27/16.
 */
public class ReverseWords151 {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] arr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("    "));
    }
}
