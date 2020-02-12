


class Solution28 {
    /**
     * Notes:
     *     1. Will return 0 when `t` is an empty string. This is consistent to C's strstr() and Java's indexOf().
     *
     * Problem Analysis:
     *     1. The for loop upper bound is `s.length() - t.length() + 1`, when i higher than this bound, it's obvious will return -1.
     *     2. Use `j == t.length()` to check `t` is match.
     *
     * General Cases:
     *     1. j >= t.length() || s.charAt(i + j) != t.charAt(j); ---> while loop break;
     *     2. j <  t.length() && s.charAt(i + j) == t.charAt(j); ---> while loop continue;
     *     note: i + j is guaranteed not out of bound of string `s`, since i < s.length() - t.length() + 1,
     *           and j at most is t.length() - 1, so i + j < s.length()
     *
     * Corner Cases:
     *     1. t == null || t.length() == 0; ---> return 0;
     *
     * Time:  best  O(n), assume s.length() is `n`, t.length() is `m`, e.g. s = 'abcdefjhi', t = 'z'
     *        worst O(mn), e.g. s = "aaaaaaaa", t = "aaab"
     *        avg   O(mn)
     * Space: O(1)
     */
    public int strStr(String s, String t) {
        if (t == null || t.length() == 0) {
            return 0;
        }
        int len = s.length() - t.length() + 1;
        for (int i = 0; i < len; i++) {
            int j = 0;
            while (j < t.length() && s.charAt(i + j) == t.charAt(j)) {
                j++;
            }
            if (j == t.length()) {
                return i;
            }
        }
        return -1;
    }
}
