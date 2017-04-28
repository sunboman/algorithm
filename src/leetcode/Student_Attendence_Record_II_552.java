package leetcode;

/**
 * Created by bosun on 4/28/17.
 */
public class Student_Attendence_Record_II_552 {
  int m = 1000000007;

  public int checkRecord(int n) {
    long[] p = new long[n + 1];
    long[] porl = new long[n + 1];
    p[0] = 1;
    porl[0] = 1;
    p[1] = 1;
    porl[1] = 2;
    for (int i = 2; i <= n; i++) {
      p[i] = porl[i - 1];
      porl[i] = (p[i] + p[i - 1] + p[i - 2]) % m;
    }
    long res = porl[n];
    for (int i = 0; i < n; i++) {
      long temp = (porl[i] * porl[n - i - 1]) % m;
      res = (res + temp) % m;
    }
    return (int) res;
  }
}
