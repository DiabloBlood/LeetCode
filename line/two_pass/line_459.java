


class Solution459 {
    /**
     * Notes:
     *     1. Non-empty string
     *     2. Multiple copies, which means only one copy like "a" or "ab" will return false.
     *
     * Problem Analysis:
     *     1. Brute force all possible substring, 1 <= len <= n / 2, if n == 8, then len between [1, 4],
     *        use `n % len == 0` check if n is divisible by len, this is a small optimization.
     *     2. Repeatly match target [0, len - 1] with range [len, 2*len - 1], [len, 3*len - 1] ... [len, k*len - 1],
     *        where k == n / len, finally `i` will out of bound at k * len == n.
     *     3. In private method `isMatch`, `i + j` is impossible out of bound. Since when the last time into while loop,
     *        i == (k-1) * len, and j < len, so i + j < k * len == n, and next round i == k * len == n, while loop break.
     *
     * General Cases:
     *     1. i < n  && isMatch(s, i, len);  ---> i += len; // while loop continue
     *     2. i == n || !isMatch(s, i, len); ---> // while loop break
     *
     * Corner Cases:
     *     1. s == null; ---> return false; // otherwise `int n = s.length();` will throw `NullPointerException()`.
     *     2. s.length() == 0; ---> // doesn't need to handle, will skip for loop and return false;
     *     3. s.length() == 0; ---> // doesn't need to handle, will skip for loop and return false;
     *
     * Time:  O(n^2), for loop takes `n/2`, while loop takes at most `n`, so upper bound is O(n^2)
     *               definitely will less than `n^2`, since `n % len != 0` will skip some for loop rounds.
     * Space: O(1), don't use any StringBuilder, substring method, which will introduce extra space usage.
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null) {
            return false;
        }
        int n = s.length();
        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) {
                continue;
            }
            int i = len;
            while (i < n && isMatch(s, i, len)) {
                i += len;
            }
            if (i == n) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(String s, int i, int len) {
        for (int j = 0; j < len; j++) {
            if (s.charAt(i + j) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
