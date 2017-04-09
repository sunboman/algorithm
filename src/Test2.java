import java.util.*;

/**
 * Created by bosun on 4/7/17.
 */
public class Test2 {
/*  public String divide(int[] array) {
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
  }
  private boolean isValid(int avg, int[] array,int[] temp, int idx, boolean[] taken, List<Set<Integer>> sets) {
    if (temp[idx] == avg) {
      if (idx == 1) return true;
      return isValid(avg, array, temp, idx + 1, taken, sets);
    }
    int n = array.length;
    for (int i = 0; i < n; i++) {
      if (taken[i]) {
        continue;
      }
      if (temp[i] + array[i] <= avg) {
        sets.get(idx).add(i);
        temp[i]
      }
    }
  }*/

  public static void main(String[] args) {

  }
}
