package leetcode;

/**
 * Created by bosun on 4/26/17.
 */
public class Count_The_Repetitions_466 {
  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    int n = s1.length(), m = s2.length();
    int count1 = 1, count2 = 0, i = 0, j = 0;
    while (count1 <= n1) {
      if (s1.charAt(i) == s2.charAt(j)) {
        if (++j == m) {
          j = 0;
          count2++;
        }
      }
      if (++i == n) {
        i = 0;
        count1++;
      }
    }
    return count2 / n2;
  }

  public static void main(String[] args) {
    new Count_The_Repetitions_466().getMaxRepetitions("acb", 4, "ab", 2);
  }
}
