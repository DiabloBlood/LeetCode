


public class Solution159 {
    /**
     * Problem Analysis:
     *     1. Keep [p1, p2 - 1] as a valid substring, contains either one c1, or two characters c1, c2.
     *     2. Keep [p2, i - 1] only contains a single character, either c1 or c2, then [p1, i - 1] is a valid sub string.
     *             a  aaa    or     a aaa b bbb     or    a aaabbbaabbb aaa 
     *           p1/p2  i           p1    p2  i           p1          p2  i
     *     3. There are 2 cases of p2:
     *        case 1: p2 == 0, range [p1, p2 - 1] is [0, -1], now range [0, i - 1] only contains a single character, likes "aaaa".
     *        case 2: p2 > 0, range [p1, p2 - 1] is a valid substring, contains either 1 or 2 characters, likes "aaaabbbb", "aaaabbbaabbbaaa".
     *
     * General Case:
     *     1. s[i] == s[i - 1];                                ---> max(i - p1 + 1);
     *                                                           // means [p2, i] still a single char substring, so [p1, i] is valid.
     *     2. s[i] != s[i - 1] && p2 == 0;                     ---> p2 = i; max(i - p1 + 1);
     *                                                           // move p2 to i, now [p2, i] just one char c2, [p1, p2 - 1] is a
     *                                                              single char substring that just contains c1. Now [p1, i] is valid.
     *     3. s[i] != s[i - 1] && p2 > 0 && s[i] == s[p2 - 1]; ---> p2 = i; max(i - p1 + 1);
     *                                                           // If now [p1, p2 - 1] contains c1, c2, [p2, i - 1] contains c2, then
     *                                                              s[i] meet c1 again, move p2 to i, then [p1, p2 - 1] still just contains
     *                                                              c1 and c2, but [p2, i] just contains c1 now, now [p1, i] is valid. 
     *     4. s[i] != s[i - 1] && p2 > 0 && s[i] != s[p2 - 1]; ---> p1 = p2; p2 = i; max(i - p1 + 1);
     *                                                           // If now [p1, p2 - 1] contains c1, c2, [p2, i - 1] contains c2, then
     *                                                              s[i] meet a new character c3. Move p2 to p1, p2 to i, then from now
     *                                                              on [p1, p2 - 1] just contains c2, [p2, i] just contains c3. [p1, i]
     *                                                              only contains c2, c3 and valid again.
     *
     * Initialization:
     *     1. i = 1;   ---> // avoid `i - 1` out of bound, then from very beginning [p1, p2 - 1], [p2, i - 1] are valid.
     *     2. max = 1; ---> // since i from 1, if s.length() == 1, for loop will skipped and return value should be 1.
     *     3. p1 = 0;  ---> // from very beginning [p1, p2 - 1], [p2, i - 1] are valid.
     *     4. p2 = 0;  ---> // from very beginning [p1, p2 - 1], [p2, i - 1] are valid.
     *
     * Corner Cases:
     *     1. s == null;       ---> return 0; // otherwise `i < s.length();` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> return 0; // if doesn't handle this case, will skip for loop and return `1`, which is wrong.
     *     3. s.length() == 1; ---> // doesn't need to handle, will skip for loop and return `1`.
     *
     * Time:  O(n), one pass for loop.
     * Space: O(1)
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        int p1 = 0;
        int p2 = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (p2 > 0 && s.charAt(i) != s.charAt(p2 - 1)) {
                    p1 = p2;
                }
                p2 = i;
            }
            max = Math.max(max, i - p1 + 1);
        }
        return max;
    }
}
