package xwan;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xwan on 3/31/17.
 */
public class NumberOfDeck {

    public int count(int[] A, int[] B, int M, int X, int Y) {
        if (A == null || A.length == 0 || M == 0 || X == 0 || Y <= 0) return 0;
        int count = 0;

        return count;
    }
    public int numOfDecks(String[] arr) {
        if (arr == null || arr.length < 52) return 0;
        List<String> cards = Arrays.asList("2S", "2C", "2H", "2D",
                "3S", "3C", "3H", "3D",
                "4S", "4C", "4H", "4D",
                "5S", "5C", "5H", "5D",
                "6S", "6C", "6H", "6D",
                "7S", "C", "7H", "7D",
                "8S", "8C", "8H", "8D",
                "9S", "9C", "9H", "9D",
                "TS", "TC", "TH", "TD",
                "JS", "JC", "JH", "JD",
                "QS", "QC", "QH", "QD",
                "AS", "AC", "AH", "AD",
                "KS", "KC", "KH", "KD");
        int[] nums = new int[52];
        for (int i = 0; i < arr.length; i++) {

        }
        return 0;
    }
}
