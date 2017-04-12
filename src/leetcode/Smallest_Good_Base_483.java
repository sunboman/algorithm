package leetcode;

/**
 * Created by bosun on 4/11/17.
 */
public class Smallest_Good_Base_483 {
  public String smallestGoodBase(String n) {
    long num = Long.parseLong(n);
    for (long p = 62; p >= 1; p--) {
      if ((1 << p) < num) {
        long l = 2, r = (long) (Math.pow(num, 1.0 / p) + 1);
        while (l < r) {
          long mid = l + (r - l) / 2;
          long sum = 0, cur = 1;
          for (int i = 0; i <= p; i++) {
            sum += cur;
            cur *= mid;
          }
          if (sum == num)
            return mid + "";
          else if (sum > num) r = mid;
          else l = mid + 1;
        }
      }
    }
    return String.valueOf(num - 1);
  }

  public static void main(String[] args) {
    String s = new Smallest_Good_Base_483().smallestGoodBase("1000000000000000000");
  }
}
