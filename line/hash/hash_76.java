


class Solution76 {
    /**
     * Problem Analysis:
     *     1. Please refer 438 (Find All Anagrams in a String)
     *     2. Please notify `map[s.charAt(start++)]++ == 0` use `==` is enough.
     *
     * General Cases:
     *     1. count == 0; ---> while loop continue; // which means range [start, i] is a valid sliding window.
     *                        // Now must have map[s[i]] == 0, use start++ to found map[s[start]] == 0, when
     *                           map[s[start]] == 0 found, [start, i] is a potential min size window.
     *
     * Corner Cases:
     *     1. s == null || t == null;  ---> return ""; // otherwise `i < s.length();` or `i < t.length();` will throw `NullPointerException`.
     *     2. s.length() < t.length(); ---> // doesn't need to handle, 2nd for loop will run but never `count == 0` and finally return an empty string.
     *     3. t.length() == 0; ---> return ""; // otherwise `map[s.charAt(start++)]++ == 0` will throw `StringIndexOutOfBoundsException`.
     *     4. s.length() == 0; ---> // doesn't need to handle, will skip 2nd for loop and finally return an empty string.
     *
     * Time:  O(m + n), assume string s length is `n`, string t length is `m`, 1st for loop takes `m`, 2nd for loop takes at most `2n`.
     * Space: O(1), array map takes constant space.
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() == 0) {
            return "";
        }
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int left = 0;
        int min = Integer.MAX_VALUE;
        int count = t.length();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (i - start + 1 < min) {
                    left = start;
                    min = i - start + 1;
                }
                if (map[s.charAt(start++)]++ == 0) {
                    count++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(left, left + min);
    }
}
