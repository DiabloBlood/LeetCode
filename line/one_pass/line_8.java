


public class Solution8 {
    /**
     * Problem Analysis:
     *     1. 
     *
     * General Cases:
     *     1. i < n && str.charAt(i) == ' '; ---> while loop continue; // i < n is for corner case "   ", all chars are whitespaces.
     *     2. i < n && (str.charAt(i) == '+' || str.charAt(i) == '-'); ---> // handle sign after whitespaces.
     *     3. digit < 0 || digit > 9; ---> // break out when char is not digit.
     *
     * Corner Cases:
     *     1. str == null;        ---> return 0; // otherwise `i`nt n = str.length();` will throw `NullPointerException`.
     *     2. str.length() == 0;  ---> // will skip 1st and 2nd while loop, skip handle signs if condition and fianlly return `0`.
     *     3. case "    ";        ---> // will skip handle signs if condition and 2nd while loop and fianlly return `0`
     *     3. case "+1";          ---> // '+' sign also should been handled.
     *     4. case "+-2";         ---> // will break out 2nd while loop 1st if condition, finally return `0`.
     *     5. case "words 987";   ---> // will break out 2nd while loop 1st if condition, finally return `0`.
     *     7. case "2147483648";  ---> // when num == 214748364, digit == 8, meet with `num == Integer.MAX_VALUE / 10`, and
     *                                   `digit > Integer.MAX_VALUE % 10 == 7`, will return "2147483647"
     *     8. case "2147483647";  ---> // when num == 214748364, digit == 7, meet with `num == Integer.MAX_VALUE / 10`, but not
     *                                   `digit > Integer.MAX_VALUE % 10 == 7`, will skip overflow condition check and finally return "2147483647".
     *     9. case "2147483646";  ---> // same as case 8, finally return "2147483646", num between "2147483640" ~ "2147483647" all same as case 8.
     *    10. case "-2147483647"; ---> // when num == 214748364, digit == 7, meet with `num == Integer.MAX_VALUE / 10`, but not
     *                                    `digit > Integer.MAX_VALUE % 10 == 7`, will skip overflow condition check and finally return "-2147483647".
     *    11. case "-2147483648"; ---> // when num == 214748364, digit == 8, meet with `num == Integer.MAX_VALUE / 10`, and
     *                                    `digit > Integer.MAX_VALUE % 10 == 7`, will return "-2147483648".
     *    12. case "-2147483649"; ---> // same as case 11
     *
     * Time:  O(n), one pass, time take `1 ~ n` depends on if break out early.
     * Space: O(1), no extra space been used.
     */
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int n = str.length();
        int num = 0;
        int sign = 1;
        int i = 0;

        // escape leading spaces
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        // handle signs
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        while (i < n) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return num * sign;
    }
}
