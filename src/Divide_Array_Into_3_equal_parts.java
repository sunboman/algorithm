import java.util.*;

/**
 * Created by bosun on 4/7/17.
 */
public class Divide_Array_Into_3_equal_parts {
  public String divide(int[] array) {
    if (array == null || array.length < 3) {
      return "impossible";
    }
    int sum = 0;
    for (int i : array) sum += i;
    if (sum % 3 != 0) return "impossible";
    int avg = sum / 3;
    List<Set<Integer>> sets = new ArrayList<>(3);
    for (int i = 0; i < 3; i++) {
      sets.add(new HashSet<>());
    }
    int[] temp = new int[3];
    int n = array.length;
    if (isValid(avg, array, temp, n - 1, 0, new boolean[n], sets)) {
      char[] c_array = new char[]{'R', 'G', 'B'};
      char[] res = new char[n];
      for (int i = 0; i < 3; i++) {
        for (int idx : sets.get(i)) {
          res[idx] = c_array[i];
        }
      }
      for (int i = 0; i < n; i++) {
        if (res[i] == '\u0000') {
          res[i] = 'B';
        }
      }
      return new String(res);
    } else {
      return "impossible";
    }
  }

  private boolean isValid(int avg, int[] array, int[] temp, int maxIdx, int idx, boolean[] taken, List<Set<Integer>> sets) {
    int n = array.length;
    if (temp[idx] == avg) {
      if (idx == 1) return true;
      return isValid(avg, array, temp, n - 1, idx + 1, taken, sets);
    }
    for (int i = maxIdx; i >= 0; i--) {
      if (taken[i]) {
        continue;
      }
      if (temp[idx] + array[i] <= avg) {
        sets.get(idx).add(i);
        temp[idx] += array[i];
        taken[i] = true;
        boolean flag = isValid(avg, array, temp, i - 1, idx, taken, sets);
        temp[idx] -= array[i];
        taken[i] = false;
        if (flag) {
          return true;
        } else {
          sets.get(idx).remove(i);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String s = new Divide_Array_Into_3_equal_parts().divide(new int[]{1, 2, 2, 2, 5});
  }
}
