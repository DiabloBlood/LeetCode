/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


Type        Description                 Default     Size        Example Literals
boolean     true or false               false       1 bit       true, false
byte        twos complement integer     0           8 bits      (none)
char        Unicode character           \u0000      16 bits     'a', '\u0041', '\101', '\\', '\'', '\n', 'ß'
short       twos complement integer     0           16 bits     (none)
int         twos complement integer     0           32 bits     -2, -1, 0, 1, 2
long        twos complement integer     0           64 bits     -2L, -1L, 0L, 1L, 2L
float       IEEE 754 floating point     0.0         32 bits     1.23e100f, -1.23e-100f, .3f, 3.14F
double      IEEE 754 floating point     0.0         64 bits     1.23456e300d, -1.23456e-300d, 1e1d
*/


public class Solution3 {

    /*
    * Case analysis: "abcdebghig"
    * 1. map[c] == notFound: map[c] = i, which means first find a char.
    * 2. map[c] != notFound && start < map[c]: start = map[c] + 1; map[c] = i; which means the next index of the last c.
    * cases: "abba" !!! start cannot push back !!!
    */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        final int notFound = -1;
        int[] map = new int[128];
        Arrays.fill(map, notFound);

        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] != notFound && start < map[c]) {
                start = map[c] + 1;
            }
            map[c] = i;
            max = Integer.max(i - start + 1, max);
        }
        return max;
    }

    /*
    * This answer is wrong. Cannot pass test case "dvdf".
    */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        boolean[] map = new boolean[128];

        int max = 0;
        int start = 0;

        int len = s.length();
        for (int i = 0; i <= len; i++) {
            if (i == len || map[s.charAt(i)]) {
                max = Math.max(i - start, max);
                Arrays.fill(map, false);
                start = i;
            }
            if (i < len) {
                map[s.charAt(i)] = true;
            }
        }
        return max;
    }
}