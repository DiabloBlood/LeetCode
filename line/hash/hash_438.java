


class Solution438 {
    /**
     * Problem Analysis:
     *     1. Keep a sliding window with size p.length() and scan all the windows in string s.
     *     2. Use an array map record character-count info of string p, when scan every sliding window in
     *        string s, counteract the count of each character, if total count equals to 0, then a target
     *        index found.
     *
     * General Cases:
     *     a. Counteraction char count part
     *        1. map[s.charAt(i)] > 0;  ---> count--; map[s.charAt(i)]--; // which means this char in string p, reduce total count.
     *        2. map[s.charAt(i)] <= 0; ---> map[s.charAt(i)]--; // which means this char not in string p
     *     b. Result checking part
     *        1. count == 0; ---> result.add(start); // which means range [start, i] is an anagram of string p. please note that at 
     *                                                  the beginning of the for loop, where i - start + 1 < p.length(), count > 0 is
     *                                                  guaranteed, so if count == 0, there must be window size i - start + 1 == p.length()
     *        2. count >  0; ---> // do nothing
     *        3. count <  0; ---> // impossible
     *     c. Adjust sliding window part
     *        1. i - start + 1 == p.length() && map[s.charAt(start)] >= 0; ---> count++; map[s.charAt(start)]++; start++;
     *           // please note that at first `p.length() - 1` rounds the sliding window not build up already, so it doesn't need to move
     *              left window bound `start`. `map[s.charAt(start)] >= 0` means char `s.charAt(start)` in string p, and an equal count
     *              should be recovered. Notes a case, s = "aaaaaa", p = "abc", if map['a'] < 0 then doesn't recover, even though char `a`
     *              in string p.
     *        2. i - start + 1 == p.length() && map[s.charAt(start)] <  0; ---> map[s.charAt(start)]++; start++;
     *           // only recover the count of char `s.charAt(start)` but not recover the total count.
     *
     * Corner Cases:
     *     1. s == null || p == null;  ---> return new ArrayList<>(); // otherwise `i < s.length();` or `i < p.length();` will throw `NullPointerException`.
     *     2. p.length() == 0;         ---> return new ArrayList<>(); // must be handled, otherwise return value = [0, 0, 0, 0, ...]
     *     2. s.length() < p.length(); ---> // 2nd for loop will run but never build a sliding window with size `p.length()` and
     *                                         finally return an empty array list.
     *
     * Time:  O(m + n), assume string s length is `n`, string p length is `m`, 1st for loop takes `m`, 2nd for loop takes `n`.
     * Space: O(1), array map takes constant space.
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || p.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] map = new int[128];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i)]++;
        }
        int count = p.length();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] > 0) {
                count--;
            }
            map[s.charAt(i)]--;
            if (count == 0) {
                result.add(start);
            }
            if (i - start + 1 == p.length()) {
                if (map[s.charAt(start)] >= 0) {
                    count++;
                }
                map[s.charAt(start)]++;
                start++;
            }
        }
        return result;
    }

    /**
     * Same method with the upper one, but with more concise coding style/format
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || p.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] map = new int[128];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i)]++;
        }
        int count = p.length();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]-- > 0) {
                count--;
            }
            if (count == 0) {
                result.add(start);
            }
            if (i - start + 1 == p.length() && map[s.charAt(start++)]++ >= 0) {
                count++;
            }
        }
        return result;
    }

    // 2. p.length() == 0;         ---> return new ArrayList<>(); // must be handled, otherwise return value = [0, 0, 0, 0, ...]
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || p.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int m = p.length();
        int count = m;
        int[] map = new int[128];
        for (int i = 0; i < m; i++) {
            map[p.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] > 0) {
                count--;
            }
            map[s.charAt(i)]--;
            if (i > m - 1) {
                map[s.charAt(i - m)]++;
                if (map[s.charAt(i - m)] > 0) {
                    count++;
                }
            }
            if (count == 0) {
                result.add(i - m + 1);
            }
        }
        return result;
    }
}
