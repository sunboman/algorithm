package leetcode;

/**
 * Created by bosun on 4/28/17.
 */
public class Remove_K_Digits_402 {
  public String removeKdigits(String num, int k) {
    if (k <= 0) return num;
    if (num == null || num.length() == 0 || k >= num.length()) return "0";
    int n = num.length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char c = num.charAt(i);
      while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
        sb.deleteCharAt(sb.length() - 1);
        k--;
      }
      sb.append(num.charAt(i));
    }
    while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
    if (k >= sb.length()) return "0";
    else return sb.toString().substring(0, sb.length() - k);
  }

  public static void main(String[] args) {
    String s = new Remove_K_Digits_402().removeKdigits("1234567890", 9);
  }
}
