


class Solution266 {
    /**
     * Problem Analysis:
     *     1. If a string could form a palindrome, only 2 cases,
     *        case 1: all characters are even count.
     *        case 2: only one character is odd count, all of other characters are even count.
     *     2. Use an array map to track count of all characters. If a string could form a palindrome,
     *        must have ---> sum <= 1 ---> where sum += value % 2.
     *     3. The variable `sum` is impossible has integer overflow, since the max sum is 128 or 26 (if just lower letters).
     *
     * Corner Cases:
     *     1. s == null; ---> return false; // otherwise `i < s.length();` will throw `NullPointerException`.
     *
     * Time:  O(n), first for loop takes `n`, 2nd for loop takes O(1).
     * Space: O(1), array map is constant space.
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        }
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c]++;
        }
        int sum = 0;
        for (int value: map) {
            sum += value % 2;
        }
        return sum <= 1;
    }

    /**
     * Counteract count of same characters
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        }
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c] = map[c] > 0 ? 0 : 1;
        }
        int sum = 0;
        for (int value: map) {
            sum += value;
        }
        return sum <= 1;
    }

    /**
     * Counteract count of same characters
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        }
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c] ^= 1;
        }
        int sum = 0;
        for (int value: map) {
            sum += value;
        }
        return sum <= 1;
    }
}
