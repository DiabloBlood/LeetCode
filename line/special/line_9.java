


public class Solution9 {
    /**
     *
     * Initialization:
     *     1. long num = 0; ---> // avoid integer overflow
     *
     * General Cases:
     *     1. i < j; ---> while loop continue; // "123321", finally i == 3, j == 2; "12321" finally i == 2, j == 2.
     *                                            that's why don't use `i <= j`
     *
     * Corner Cases:
     *     1. x == 0;       ---> // doesn't need to handel, s == "0".
     *     2. x is negtive; ---> // doesn't need to handel, sign will be put in string.
     *
     * Time:  O(1), 2^31 ~ 10^10, `String.valueOf` at most takes `10` rounds, while loop at most takes `10` rounds.
     * Space: O(1), string at most takes `10` length.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int cache = x;
        long num = 0;
        while (x != 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return num == cache;
    }

    /**
     * Transfer to string method
     *
     * General Cases:
     *     1. i < j; ---> while loop continue; // "123321", finally i == 3, j == 2; "12321" finally i == 2, j == 2.
     *                                            that's why don't use `i <= j`
     *
     * Corner Cases:
     *     1. x == 0;       ---> // doesn't need to handel, s == "0".
     *     2. x is negtive; ---> // doesn't need to handel, sign will be put in string.
     *
     * Time:  O(1), 2^31 ~ 10^10, `String.valueOf` at most takes `10` rounds, while loop at most takes `10` rounds.
     * Space: O(1), string at most takes `10` length.
     */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
