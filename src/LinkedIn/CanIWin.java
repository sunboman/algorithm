package LinkedIn;

import java.util.*;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((maxChoosableInteger * (maxChoosableInteger + 1)) / 2 < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return canWin(map, used, desiredTotal);
    }
    
    private boolean canWin(Map<Integer, Boolean> map, boolean[] used, int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        int k = formatToBitVector(used);
        if (!map.containsKey(k)) {
            for (int i = 1; i < used.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                if (!canWin(map, used, desiredTotal - i)) {
                    used[i] = false;
                    map.put(k, true);
                    return true;
                }
                used[i] = false;
            }
            map.put(k, false);
        }
        return map.get(k);
    }
    
    private int formatToBitVector(boolean[] used) {
        int num = 0;
        for (boolean boo : used) {
            num <<= 1;
            if (boo) {
                num |= 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        boolean res = new CanIWin().canIWin(10, 11);
    }
}