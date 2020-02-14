


class Solution696 {
    /**
     * Problem Analysis:
     *     1. For input "0001111", should has 3 typical substrings, "000111", "0011", "000111", the iput has 3 `0`s and 4 `1`s,
     *        So the total substrings of this input is min(3, 4) = 3.
     *     2. Use two count variable `prev` and `cur` to track last two piece of consecutive '0's and '1's, then when digit
     *        switch, count min(prev, cur) into result.
     *
     * General Cases:
     *     1. i == n;                    ---> res += min(prev, cur); prev = cur; cur = 1; // out of bound equal to digit switch.
     *     2. i < n && s[i] != s[i - 1]; ---> res += min(prev, cur); prev = cur; cur = 1;
     *     3. i < n && s[i] == s[i - 1]; ---> cur++;
     *     combine case 1 and 2:
     *     1. i == n || s[i] != s[i - 1]; ---> res += min(prev, cur); prev = cur; cur = 0; cur++;
     *     2. i <  n && s[i] == s[i - 1]; ---> cur++;
     *     then cur++ could be extract out.
     *
     * Initialization:
     *     1. prev = 0; // at beginning, only has one kind of digit, `0` or `1`, so the first piece count is 0.
     *     2. i = 1;    // for s[i] and s[i - 1] comparation.
     *     3. cur = 1;  // since i = 1, the current piece count should be 1.
     *
     * Corner Cases:
     *     1. s == null; ---> return 0; // otherwise `i <= s.length()` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> // doesn't need to handle, will skip for loop and return 0.
     *     3. s.length() == 1; ---> // doesn't need to handle, will skip for loop and return 0.
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public int countBinarySubstrings(String s) {
        if (s == null) {
            return 0;
        }
        int res = 0;
        int prev = 0;
        int cur = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(prev, cur);
                prev = cur;
                cur = 0;
            }
            cur++;
        }
        return res;
    }
}
