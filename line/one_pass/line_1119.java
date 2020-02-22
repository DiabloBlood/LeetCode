


public class Solution1119 {
    /**
     * Notes:
     *     1. s consists of lowercase English letters only.
     *     2. 1 <= s.length <= 1000.
     *
     * General Cases:
     *     1. vowels.indexOf(s.charAt(i)) == -1; --->
     *     2. vowels.indexOf(s.charAt(i)) != -1; ---> // do nothing, skip this char.
     *
     * Corner Cases:
     *     1. s == null; ---> return null; // otherwise `s.length()` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> // doesn't need to handle, for loop will be skipped and return an empty string.
     *
     * Time:  O(n ~ 2n), for loop takes `n`, sb.toString() takes `1 ~ n`,
     *                   `1` means all chars are vowels, `n` means no char is vowel.
     * Space: O(1 ~ n),  `1` means all chars are vowels, `n` means no char is vowel.
     */
    public String removeVowels(String s) {
        if (s == null) {
            return null;
        }
        String vowels = "aeiou";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
