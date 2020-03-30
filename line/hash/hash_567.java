


public class Solution567 {
    /**
     * Problem Analysis:
     *     1. Please refer 438 (Find All Anagrams in a String)
     *
     * Corner Cases:
     *     1. s1 == null || s2 == null;  ---> return false; // otherwise `i < s1.length();` or `i < s2.length();` will throw `NullPointerException`.
     *     2. s1.length() == 0;          ---> // doesn't need to handle, return `true` is OK, will go into 2nd for loop and return `true` since `count == 0`.
     *     2. s2.length() < s1.length(); ---> // 2nd for loop will run but never build a sliding window with size `s2.length()` and
     *                                           finally return `false`.
     *
     * Time:  O(m + n), assume string s1 length is `m`, string s2 length is `n`, 1st for loop takes `m`, 2nd for loop takes `n`.
     * Space: O(1), array map takes constant space.
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int[] map = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)]++;
        }
        int count = s1.length();
        int start = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (map[s2.charAt(i)]-- > 0) {
                count--;
            }
            if (count == 0) {
                return true;
            }
            if (i - start + 1 == s1.length() && map[s2.charAt(start++)]++ >= 0) {
                count++;
            }
        }
        return false;
    }
}
