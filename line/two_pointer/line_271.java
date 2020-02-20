


public class Solution271 {
    /**
     * Encodes a list of strings to a single string.
     *
     * Notes:
     *     1. The string may contain any possible characters out of 256 valid ascii characters.
     *        Your algorithm should be generalized enough to work on any possible characters.
     *     2. Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
     *     3. Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
     *
     * Problem Analysis:
     *     1. Use any mark other than '/' of the 256 valid ascii characters, which will not change the result.
     *        The reason is if the length of a single string longer than 9, we will not know the length of this string
     *        when decode this string, since this string may has leading digit. So we need a mark to specify the digits length.
     *     2. When decode this string, traverse pointer could jump by string length instead of increment one by one.
     *
     * Corner Cases:
     *     1. strs == null;     ---> return ""; // otherwise `for (String s: strs)` will throw `NullPointerException`.
     *     2. strs.length == 0; ---> // doesn't need to handle, will skip for loop and return an empty string.
     *
     * Time:  O(2mn), assume string avg length is `m`, strs array length is `n`,
     *               for loop takes `mn`, sb.toString takes `mn`.
     * Space: O(mn), string builder takes `mn` space.
     */
    public String encode(List<String> strs) {
        if (strs == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    /**
     * Decodes a single string to a list of strings.
     *
     * Corner Cases:
     *     1. s == null;       ---> return new ArrayList<>(); // otherwise `while (i < s.length())` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> // doesn't need to handle, will skip for loop and return an empty array list.
     *
     * Time:  O(mn), assume string avg length is `m`, strs array length is `n`, `s.substring(i + 1, i + len + 1)` takes `m`,
     *               while loop jump steps is `n`.
     * Space: O(1)
     */
    public List<String> decode(String s) {
        if (s == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int start = 0;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) != '/') {
                i++;
                continue;
            }
            int len = Integer.parseInt(s.substring(start, i));
            result.add(s.substring(i + 1, i + len + 1));
            start = i + len + 1;
            i = start + 1;
        }
        return result;
    }
}
