


public class Solution14 {
    /**
     * Notes:
     *     1. `String.indexOf` method not use KMP algorithm, time complexity is O(mn),
     *        `m` is length of target string, `n` is length of source string.
     * 
     * General Cases:
     *     1. i >= s.length(); ---> return sb.toString(); // longest common prefix length is impossible longer than the string
     *                                                       with shortest length in this input array. If this case takes place,
     *                                                       which means `s` is the smallest string in input string array.
     *     2. i < s.length() && s.charAt(i) != c; ---> return sb.toString();
     *     3. i < s.length() && s.charAt(i) == c; ---> // do nothing
     *
     * Corner Cases:
     *     1. strs == null;     ---> return ""; // otherwise `int len = strs[0].length();` will throw `NullPointerException`.
     *     2. strs.length == 0; ---> return ""; // otherwise `int len = strs[0].length();` will throw `ArrayIndexOutOfBoundsException`.
     *
     * Time:  O(mn), assume input array length is `n`, avg length of a single string is `m`.
     *               outer for loop takes `m`, inner for loop takes `n`.
     * Space: O(1)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if (i >= s.length() || s.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Most votes method in leetcode, but the time complexity is not good.
     * 
     * Notes:
     *     1. `String.indexOf` method not use KMP algorithm, time complexity worst O(mn), best is O(n)
     *        `m` is length of target string, `n` is length of source string.
     *
     * Time: worst O(m^2 * n), assume input array length is `n`, avg length of a single string is `m`.
     *                          outer for loop takes `n`, while loop `indexOf` worst is `m^2`
     *       besst O(mn), outer for loop takes `n`, while loop `indexOf` best is `m`
     * Space: O(1)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length()-1);
        return pre;
    }
}
