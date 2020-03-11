


public class Solution3 {
    /**
     * Problem Analysis:
     *     1. Use an array map to track the last appeared index of current character.
     *        Which means check if s[i] appeared before at range [start, i - 1].
     *
     * General Cases:
     *     1. map[c] <  start; ---> map[c] = i; // which means this is the first appearance of `c` between [start, i].
     *     2. map[c] >= start; ---> max(max, i - start); start = map[c] + 1; map[c] = i;
     *                           // which means `c` appear 2nd time at position `i`, record [start, i - 1]
     *                              length, which is a substring without repeating characters.
     *     3. i == s.length(); ---> max(max, s.length() - start); // record length of [start, n - 1]. Put this line as final code.
     *
     * Corner Cases:
     *     1. s == null;       ---> return 0; // otherwise `i <= s.length();` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> return 0; // doesn't need to handle, will skip for loop and finally return `0`.
     *
     * Time:  O(n), for loop takes `n` time.
     * Space: O(1), array map only use constant O(1) space.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0;
        int[] map = new int[128];
        Arrays.fill(map, -1);
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] >= start) {
                max = Math.max(max, i - start);
                start = map[c] + 1;
            }
            map[c] = i;
        }
        max = Math.max(max, s.length() - start);
        return max;
    }

    /**
     * Problem Analysis:
     *     1. Use an array map to track the last appeared index of current character.
     *        Which means check if s[i] appeared before at range [start, i - 1].
     *
     * General Cases:
     *     1. map[c] <  start; ---> max(max, i - start + 1); map[c] = i;
     *                           // which means this is the first appearance of `c` between [start, i].
     *     2. map[c] >= start; ---> start = map[c] + 1; max(max, i - start + 1); map[c] = i;
     *                           // which means `c` appear 2nd time at position `i`, [start, i - 1] length already
     *                              been recorded in previous round loop. Now record [newStart, i] length. Always record valid length.
     *                              Final result max length will be the maximum length of all valid lengths.
     *
     * Corner Cases:
     *     1. s == null;       ---> return 0; // otherwise `i <= s.length();` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> return 0; // doesn't need to handle, will skip for loop and finally return `0`.
     *
     * Time:  O(n), for loop takes `n` time.
     * Space: O(1), array map only use constant O(1) space.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0;
        int[] map = new int[128];
        Arrays.fill(map, -1);
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] >= start) {
                start = map[c] + 1;
            }
            max = Math.max(max, i - start + 1);
            map[c] = i;
        }
        return max;
    }
}
