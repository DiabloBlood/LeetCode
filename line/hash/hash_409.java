


class Solution409 {
    /**
     * Problem Analysis:
     *     1. Use an array map to track count of all characters. If the count of a character is odd, remove 1 from count.
     *        finally could leave one odd there.
     *
     * General Cases:
     *     1. odds += value & 1; ---> // or `odds += value % 2;`
     *     2. odds > 0;          ---> return n - odds + 1; // could leave a single character finally.
     *     3. odds == 0;         ---> return n; // which means all counts of characters are even.
     *
     * Corner Cases:
     *     1. s == null; ---> return false; // otherwise `int n = s.length();` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> // doesn't need to handle, will skip 1st for loop, finally odds == 0, then return 0.
     *
     * Time:  O(n), first for loop takes `n`, 2nd for loop takes O(1).
     * Space: O(1), array map is constant space.
     */
    public int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }
        int[] map = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map[s.charAt(i)]++;
        }
        int odds = 0;
        for (int value: map) {
            odds += value & 1;
        }
        return odds > 0 ? n - odds + 1 : n;
    }
}
