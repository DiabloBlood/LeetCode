


public class Solution186 {
    /**
     *
     * Notes:
     *     1. A word is defined as a sequence of non-space characters
     *     2. The input string does not contain leading or trailing spaces.
     *     3. The words are always separated by a single space.
     *
     * Problem Analysis:
     *     1. Reverse the whole array first then reverse word by word.
     *     2. Use a pointer `start` to mark the first character of word, use `i` mark the space.
     *
     * General Cases:
     *     1. i == n; ---> reverse(s, start, i - 1);
     *     2. i < n && s[i] == ' '; ---> reverse(s, start, i - 1); start = i + 1;
     *     3. i < n && s[i] != ' '; ---> // do nothing
     *     combine case 1 and 2:
     *     1. i == n || s[i] == ' '; ---> reverse(s, start, i - 1); start = i + 1;
     *                                    // please note `i == n` at first to avoid out of bound.
     *
     * Corner Cases:
     *     1. s == null;     ---> return; // otherwise `int n = s.length;` will throw `NullPointerException`
     *     2. s.length == 0; ---> // doesn't need to handle, will skip first reverse, then into for loop,
     *                               if block inside for loop and skip 2nd reverse, finally doesn't has any side effect.
     *
     * Time:  O(3n), first reverse takes `n`, for loop take `n`, reverse word by word takes `n`.
     * Space: O(1)
     */
    public void reverseWords(char[] s) {
        if (s == null) {
            return;
        }
        int n = s.length;
        reverse(s, 0, n - 1);
        int start = 0;
        for (int i = 0; i <= n; i++) {
            if (i == n || s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            swap(s, start++, end--);
        }
    }

    private void swap(char[] s, int p, int q) {
        char temp = s[p];
        s[p] = s[q];
        s[q] = temp;
    }
}
