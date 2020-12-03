


public class Solution38 {
    /**
     * Notes:
     *     1. StringBuilder not accept `char` type as constructor parameter.
     *
     * General Cases:
     *     1. j == sb.length();                                     ---> next.append(j - start).append(sb.charAt(start));
     *     2. j <  sb.length() && sb.charAt(j) != sb.charAt(start); ---> next.append(j - start).append(sb.charAt(start)); start = j;
     *     3. j <  sb.length() && sb.charAt(j) == sb.charAt(start); ---> // do nothing
     *     combine case 1 and 2:
     *     1. j == sb.length() || sb.charAt(j) != sb.charAt(start); ---> next.append(j - start).append(sb.charAt(start)); start = j;
     *                                                                   // please note `i == n` at first to avoid out of bound.
     *
     * Corner Cases:
     *     1. n <  1; ---> return ""; // otherwise for loop will be skipped and return "1".
     *     2. n == 1: ---> // doesn't need to handle, return value is "1".
     *
     * Time:  O(n), only care about the 2nd for loop, assume sb.length() is `n`, then for loop only takes `n`.
     * Space: O(n), the next string builder takes `n`
     */
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            int start = 0;
            StringBuilder next = new StringBuilder();
            for (int j = 0; j <= sb.length(); j++) {
                if (j == sb.length() || sb.charAt(j) != sb.charAt(start)) {
                    next.append(j - start).append(sb.charAt(start));
                    start = j;
                }
            }
            sb = next;
        }
        return sb.toString();
    }
}
