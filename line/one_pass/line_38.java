/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/


public class Solution38 {

    /*
     * Time:  O(n*m), maybe exponential time (c ^ n), c is small! See the Test.java, testing code
     * Space: O(m)
     *
     */

    public String countAndSay(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder cur = new StringBuilder();
            int start = 0;
            int len = sb.length();
            for (int j = 0; j <= len; j++) {
                if (j == len || sb.charAt(j) != sb.charAt(start)) {
                    cur.append(j - start).append(sb.charAt(start));
                    start = j;
                }
            }
            sb = cur;
        }
        return sb.toString();
    }
}






