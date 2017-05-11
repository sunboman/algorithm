package Pinterest;

/**
 * Created by bosun on 5/11/17.
 */
public class CanWin {
  public boolean canWin(int pos, int[] steps) {
    if (pos == 0) return true;
    if (steps == null || steps.length == 0) return false;
    return dfs(pos, 0, steps);
  }

  private boolean dfs(int pos, int index, int[] steps) {
    if (index >= steps.length) return false;
    if (pos + steps[index] == 0 || pos - steps[index] == 0) return true;
    return dfs(pos + steps[index], index + 1, steps) ||
            dfs(pos - steps[index], index + 1, steps);
  }

  public static void main(String[] args) {
    boolean res = new CanWin().canWin(1, new int[]{2, 2});
  }
}
