package xwan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwan on 3/19/17.
 */
public class OutputContestMatches544 {
    public static String findContestMatch(int n) {
        if (n < 2) return "";
        List<String> matches = new ArrayList<>();
        for (int i = 1; i <= n; i++) matches.add(String.valueOf(i));
        while (matches.size() > 1) {
            List<String> newRound = new ArrayList<>();
            for (int i = 0; i < matches.size() / 2; i++) {
                newRound.add("(" + matches.get(i) + "," + matches.get(matches.size() - i - 1) + ")");
            }
            matches = newRound;
        }
        System.out.println(matches.get(0));
        return matches.get(0);
    }

    public static void main(String[] args) {
        findContestMatch(4);
        findContestMatch(7);
        findContestMatch(10);
    }
}
