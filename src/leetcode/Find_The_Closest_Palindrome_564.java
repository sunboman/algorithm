package leetcode;

/**
 * Created by bosun on 4/23/17.
 */
public class Find_The_Closest_Palindrome_564 {
  public String nearestPalindromic(String n) {
    if (n == null || n.length() == 0) {
      return n;
    }
    int len = n.length();
    if (len == 1) {
      return Math.abs(Integer.parseInt(n) - 1) + "";
    }
    if (len >= 2 && isAllNine(n)) {
      StringBuilder sb = new StringBuilder(1 + "");
      for (int i = 0; i < len - 1; i++) sb.append('0');
      sb.append('1');
      return sb.toString();
    }
    boolean isOdd = len % 2 == 0;
    String left = n.substring(0, (len + 1) / 2);
    int[] d = new int[]{-1, 0, 1};
    String res = n;
    long minDiff = Long.MAX_VALUE;
    for (int i : d) {
      String temp = getPalindrome(Long.parseLong(left) + i + "", isOdd);
      if (temp.length() != len || Long.parseLong(temp) == 0) {
        temp = "";
        for (int j = 0; j < len - 1; j++) temp += "9";
      }
      long diff = temp.equals(n) ? Long.MAX_VALUE :
              Math.abs(Long.parseLong(temp) - Long.parseLong(n));
      if (diff < minDiff) {
        minDiff = diff;
        res = temp;
      }
    }
    return res;
  }

  private String getPalindrome(String str, boolean isOdd) {
    String right = new StringBuilder(str).reverse().toString();
    return isOdd ? str + right : str.substring(0, str.length() - 1) + right ;
  }

  private boolean isAllNine(String n) {
    for (char c : n.toCharArray()) {
      if (c != '9') return false;
    }
    return true;
  }

  public static void main(String[] args) {
    new Find_The_Closest_Palindrome_564().nearestPalindromic("230");
  }
}
