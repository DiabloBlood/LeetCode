


public class Solution205 {
    /**
     * Problem Analysis:
     *     1. Use two array maps to track index of each character of string s and string t.
     *     2. For s[i] and t[i], they should have same previous appeared indexes.
     *
     * General Cases:
     *     1. map1[c1] != map2[c2]; ---> return false;
     *     2. map1[c1] != map2[c2]; ---> map1[c1] = i + 1; map2[c2] = i + 1;
     *                              // use `1` based index, then doesn't need run Array.fill(map, -1);
     *
     * Corner Cases:
     *     1. s == null || t == null;   ---> return false; // otherwise `i < s.length();` or `char c2 = t.charAt(i);`
     *                                                        will throw `NullPointerException`.
     *     2. s.length() != t.length(); ---> return false; // otherwise `char c1 = s.charAt(i);` or `char c2 = t.charAt(i);`
     *                                                        will throw `StringIndexOutOfBoundsException`.
     *
     * Time:  O(n), one pass for loop, best is O(1) is string s and string t have different lengths.
     * Space: O(1), array map takes constant space.
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] map1 = new int[128];
        int[] map2 = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map1[c1] != map2[c2]) {
                return false;
            }
            map1[c1] = i + 1;
            map2[c2] = i + 1;
        }
        return true;
    }
}
