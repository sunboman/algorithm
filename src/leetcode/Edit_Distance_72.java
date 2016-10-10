package leetcode;

/**
 * Created by sunbo_000 on 10/6/2016.
 */
public class Edit_Distance_72 {
    public int minDistance(String word1, String word2) {
        int short_len = Math.min(word1.length(), word2.length());
        int long_len = word1.length() + word2.length() - short_len;

        String long_word = word1.length() > word2.length() ? word1 : word2;
        String short_word = word1.length() > word2.length() ? word2 : word1;

        int[] d = new int[short_len + 1];
        for (int i = 0; i <= short_len; i++) {
            d[i] = i;
        }
        int old = 0;
        int tmp = 0;
        for (int i = 1; i <= long_len; i++) {
            old = i - 1;
            d[0] = i;
            for (int j = 1; j <= short_len; j++) {
                tmp = d[j];
                if (long_word.charAt(i - 1) == short_word.charAt(j - 1)) d[j] = old;
                else {
                    d[j] = Math.min(Math.min(d[j - 1] + 1, d[j] + 1), old + 1);
                }
                old = tmp;
            }
        }

        return d[short_len];
    }


    public static void main(String[] args) {
        Edit_Distance_72 solution = new Edit_Distance_72();
        System.out.println(solution.minDistance("abda", "abcdaaa"));

    }
}
