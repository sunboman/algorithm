package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbo on 3/11/2017.
 */
public class Restore_IP_Address_93 {
  public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    if (s == null || s.length() < 4) {
      return res;
    }
    dfs(s, res, 0, 0, "");
    return res;
  }

  private void dfs(String s, List<String> res, int idx, int count, String path) {
    if (count > 4) {
      return;
    }
    if (count == 4 && idx == s.length()) {
      res.add(path);
    }
    int n = s.length();
    for (int i = 1; i < 4; i++) {
      if (idx + i > n) {
        break;
      }
      String temp = s.substring(idx, idx + i);
      if ((temp.charAt(0) == '0' && temp.length() > 1) || (i == 3 && Integer.parseInt(temp) > 255)) {
        continue;
      }
      if (count < 3) {
        temp += ".";
      }
      dfs(s, res, idx + i, count + 1, path + temp);
    }
  }

  public static void main(String[] args) {
    new Restore_IP_Address_93().restoreIpAddresses("25525511135");
  }
}
