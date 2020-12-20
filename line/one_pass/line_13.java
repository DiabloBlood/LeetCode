


public class Solution13 {
    /**
     * Notes:
     *     1. Assume the input string is a valid roman string, doesn't has case likes "IIII" or "IM".
     *
     * Problem Analysis:
     *     1. "IV" could seen as 5 - 1 = 4, "VI" could seen as 1 + 5 = 6, so if the current roman digit
     *        samller than the previous one, minus it, otherwise (larger or equal) add it.
     *     2. Use an array map to record the relationship of roman digits and arabic digits.
     *     3. Start for loop from index `n - 2`.
     *
     * General Cases:
     *     1. cur <  prev; ---> result -= cur; // likes "IV", "CM"
     *     2. cur >= prev; ---> result += cur; // likes "VI", "II"
     *
     * Corner Cases:
     *     1. s == null; ---> return 0; // otherwise `int n = s.length();` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> return 0; // otherwise `s.charAt(n - 1)` will throw `StringIndexOutOfBoundsException`.
     *
     * Time:  O(n), one pass for loop
     * Space: O(1), map takes int[128] but constant space seen as O(1)
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[128];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        int n = s.length();
        int result = map[s.charAt(n - 1)];
        for (int i = n - 2; i >= 0; i--) {
            int prev = map[s.charAt(i + 1)];
            int cur = map[s.charAt(i)];
            result += cur < prev ? -cur : cur;
        }
        return result;
    }

    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        int[] map = new int[128];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        int result = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = map[s.charAt(i)];
            result += cur < prev ? -cur : cur;
            prev = cur;
        }
        return result;
    }

    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        int[] map = new int[128];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        int result = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = map[s.charAt(i)];
            result += prev < cur ? -prev : prev;
            prev = cur;
        }
        result += prev;
        return result;
    }
}
