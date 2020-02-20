


public class Solution443 {
    /**
     * Problem Analysis:
     *     1. Use a ptr `end` to mark the tail of compressed part, [0, end - 1] is the compressed part.
     *     2. Use a ptr `start` to mark the first occurence of a character.
     *
     * General Cases:
     *     1. i == chars.length || chars[i] != chars[start]; ---> write digits of [start, i - 1]; start = i;
     *
     * Corner Cases:
     *     1. chars == null; ---> return 0; // otherwise `i <= chars.length` will throw `NullPointerException`.
     *     2. chars.length == 0; ---> return 0; // otherwise `chars[end++] = chars[start];` will throw `ArrayIndexOutOfBoundException`.
     *
     * Time:  O(n), second for loop only takes O(1) time.
     * Space: O(1), `String digits = Integer.toString(count);` only use O(1) space.
     */
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[start]) {
                chars[end++] = chars[start];
                int count = i - start;
                start = i;
                if (count > 1) {
                    String digits = Integer.toString(count);
                    for (int j = 0; j < digits.length(); j++) {
                        chars[end++] = digits.charAt(j);
                    }
                }
            }
        }
        return end;
    }

    /**
     * Use this method if cannot use `Integer.toString`.
     */
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[start]) {
                chars[end++] = chars[start];
                int count = i - start;
                start = i;
                if (count > 1) {
                    end = writeDigits(chars, end, count);
                }
            }
        }
        return end;
    }

    private int writeDigits(char[] chars, int end, int count) {
        int j = end;
        while (count > 0) {
            chars[j] = (char)('0' + count % 10);
            count /= 10;
            j++;
        }
        reverse(chars, end, j - 1);
        return j;
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
