


public class Solution387 {
    /**
     * Problem Analysis:
     *     1. Use an array map track the count of each characters.
     *
     * General Cases:
     *     1. map[s.charAt(i)] == 1; ---> return i;
     *
     * Corner Cases:
     *     1. s == null; ---> return -1; // otherwise `i < s.length();` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> // doesn't need to handle, will skip 1st and 2nd for loop and return -1.
     *
     * Time:  O(n), 1st for loop takes `n`, 2nd for loop takes O(1).
     * Space: O(1), array map takes constant space.
     */
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
