package LinkedIn;

/**
 * Created by sunbo on 1/9/2017.
 */
/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
 */
public class Reverse_Words_in_a_String_II {
    public void reverse(char[] words) {
        int left = 0;
        for (int right = 0; right <= words.length; right++) {
            if (right == words.length ) {
                reverse(words, left, words.length - 1);
                break;
            }
            if (words[right] == ' ') {
                reverse(words, left, right);
                left = right + 1;
            }
        }
        reverse(words, 0, words.length - 1);
    }
    private void reverse(char[] words, int i, int j) {
        while (i < j) {
            swap(words, i++, j--);
        }
    }
    private void swap(char[] words, int i, int j) {
        char temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    public static void main(String[] args) {
        char[] chars = "the sky is blue".toCharArray();
        new Reverse_Words_in_a_String_II().reverse(chars);
    }
}
