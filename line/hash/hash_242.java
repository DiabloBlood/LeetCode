


class Solution242 {
    /**
     * Notes:
     *     1. Why we cannot use XOR operator solve this problem? Consider case s = "aa", t = "bb".
     *
     * Problem Analysis:
     *     1. Use an array map counteracts character count of string s and string t.
     *
     * Corner Cases:
     *     1. s == null || t == null;   ---> return false; // otherwise `i < s.length();` or `t.charAt(i)` will throw `NullPointerException`.
     *     2. s.length() != t.length(); ---> return false; // otherwise cannot use one for loop traverse two strings.
     *
     * Time:  O(n), best is O(1) if length of 2 strings are different, 1st one pass for loop takes `n`, 2nd for loop is O(1).
     * Space: O(1), array map takes constant space.
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            map[t.charAt(i)]--;
        }
        for (int value: map) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * If input strings only contain lower letters, use an array map with just 26 length.
     *
     * Notes:
     *     1. Even use small space than 128, but has extra overhead to calculate index likes code `s.charAt(i) - 'a'`.
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for (int value: map) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
