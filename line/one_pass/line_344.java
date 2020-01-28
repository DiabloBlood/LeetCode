


public class Solution344 {
    /**
     * Problem Analysis:
     *     1. For input likes [abcde], `s.length` is odd, finally `i` and `j` are all at 2,
     *        and char `c` doesn't need to reverse.
     *     2. For input likes [abcdef], `s.length` is even, finally `i` at 3, `j` at 2.
     *
     * Corner Cases:
     *     1. s == null;     ---> return; // otherwise `int j = s.length - 1;` will throw `NullPointerException`.
     *     2. s.length == 0; ---> doesn't need to handle, while loop will skip.
     *
     * Time:  O(n), will call `swap` n/2 times.
     * Space: O(1)
     */
    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * A more clear method which takes advantage of `reverse` and `swap` API.
     *
     * Problem Analysis:
     *     1. For input likes [abcde], `s.length` is odd, finally `start` and `end` are all at 2,
     *        and char `c` doesn't need to reverse.
     *     2. For input likes [abcdef], `s.length` is even, finally `start` at 3, `end` at 2.
     *
     * Corner Cases:
     *     1. s == null;     ---> return; // otherwise `reverse(s, 0, s.length - 1)` will throw `NullPointerException`.
     *     2. s.length == 0; ---> doesn't need to handle, while loop will skip.
     *
     * Time:  O(n), will call `swap` n/2 times.
     * Space: O(1)
     */
    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }
        reverse(s, 0, s.length - 1);
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
