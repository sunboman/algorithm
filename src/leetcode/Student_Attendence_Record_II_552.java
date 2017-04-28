package leetcode;

/**
 * Created by bosun on 4/28/17.
 */
public class Student_Attendence_Record_II_552 {
  int m = 1000000007;

  public int checkRecord(int n) {
    long a0l0 = 1, a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;
    for (int i = 0; i < n; i++) {
      long a0l0_ = (a0l0 + a0l1 + a0l2) % m;
      a0l2 = a0l1;
      a0l1 = a0l0;
      a0l0 = a0l0_;
      long a1l0_ = (a0l0 + a1l0 + a1l1 + a1l2) % m;
      a1l2 = a1l1;
      a1l1 = a1l0;
      a1l0 = a1l0_;
    }
    return (int) ((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % m);
  }
}
