package leetcode;

import java.util.Arrays;

/**
 * Created by bosun on 5/2/17.
 */
public class Reconstruct_Original_Digits_From_English_423 {
  public String originalDigits(String s) {
    int[] count = new int[10];
    for (char c : s.toCharArray()) {
      if (c == 'z') count[0]++;
      if (c == 'w') count[2]++;
      if (c == 'x') count[6]++;
      if (c == 'g') count[8]++;
      if (c == 'v') count[7]++;
      if (c == 'u') count[4]++;
      if (c == 'h') count[3]++;
      if (c == 'f') count[5]++;
      if (c == 'i') count[9]++;
      if (c == 'o') count[1]++;
    }
    count[5] = count[5] - count[4];
    count[3] -= count[8];
    count[7] -= count[5];
    count[9] = count[9] - count[6] - count[8] - count[5];
    count[1] = count[1] - count[0] - count[2] - count[4];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      for (int j = 1; j <= count[i]; j++) {
        sb.append(i);
      }
    }
    return sb.toString();
  }



  public static void main(String[] args) {
//    new Reconstruct_Original_Digits_From_English_423().maximumGap(new int[]{1, 3, 100});
  }
}
