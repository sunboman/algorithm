package leetcode;

/**
 * Created by bosun on 3/23/17.
 */
public class Largest_Plindrome_Product_479 {
  public int largestPalindrome(int n) {
    if (n == 1) return 9;
    int max = (int) Math.pow(10, n) - 1, min = max / 10;
    long left = (long) max * (long) max / (long) Math.pow(10, n);
    boolean isPalindrome = false;
    long palindrome = 0;
    while (!isPalindrome) {
      palindrome = getPalindrome(left);
      for (long num = max; num > min; num--) {
        if (palindrome / num > max || num * num < palindrome) {
          break;
        }
        if (palindrome % num == 0) {
          return (int) (palindrome % 1337);
        }
      }
      left--;
    }
    return (int) (palindrome % 1337);
  }

  private long getPalindrome(long num) {
    String str = num + new StringBuffer(num + "").reverse().toString();
    return Long.parseLong(str);
  }

  public static void main(String[] args) {
    int res = new Largest_Plindrome_Product_479().largestPalindrome(6);
  }
}
