package xwan.lintcode.array_and_numbers;

/**
 * Created by xwan on 11/30/16.
 */
public class sort_letters_by_case_49 {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public static void sortLetters(char[] chars) {
        //write your code here
        if (chars == null || chars.length < 2) {
            return;
        }

        int n = chars.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            while (l < r && chars[l] >= 'a' && chars[l] <= 'z') {
                l++;
            }
            while (l < r && chars[r] >= 'A' && chars[r] <= 'Z') {
                r--;
            }

            swap(chars, l, r);
            l++;
            r--;
        }

        int lowEnd = r;
        int lowStart = 0;

        int upperStart = r + 1;
        int upperEnd = n - 1;

        quickSort(chars, lowStart, lowEnd);
        quickSort(chars, upperStart, upperEnd);

    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private static void quickSort(char[] chars, int start, int end) {
        if (start >= end) {
            return;
        }

        int pos = parition(chars, start, end);

        if (pos > start) {
            quickSort(chars, start, pos - 1);
        }
        if (pos < end) {
            quickSort(chars, pos + 1, end);
        }
    }

    private static int parition(char[] chars, int start, int end) {
        int lo = start;
        int hi = end;
        int pivot = chars[lo];
        lo++;

        while (lo <= hi) {
            while (lo <= hi && chars[lo] <= pivot) {
                lo++;
            }
            while (lo <= hi && chars[hi] >= pivot) {
                hi--;
            }

            if (lo < hi) {
                swap(chars, lo, hi);
            }
        }

        swap(chars, start, hi);
        return hi;
    }

    public static void main(String[] args) {
        char[] chars = {'k', 'a', 'b', 'A', 'c', 'd', 'D', 'B'};

        sortLetters(chars);

        System.out.print(chars[0]);
    }
}
