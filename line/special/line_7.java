


public class Solution7 {
    /**
     * Initialization:
     *     1. int num = 0; ---> the first digit should be num * 10 + x % 10 == x % 10, since num == 0.
     *
     * Corner Cases:
     *     1. x == 0; ---> // doesn't need to handle, will skip while loop and finally return `0`.
     *     2. x < 0;  ---> // the sign of `x` doesn't impact anything.
     *     3. num > Integer.MAX_VALUE / 10 || num < Integer.MIN_VALUE / 10; ---> return 0; // integer overflow
     *
     * Time:  O(1), 2^31 ~ 10^10, while loop at most takes `10` rounds 
     * Space: O(1), no extra space been used.
     */
    public int reverse(int x) {
        int num = 0;
        while (x != 0) {
            if (num > Integer.MAX_VALUE / 10 || num < Integer.MIN_VALUE / 10) {
                return 0;
            }
            num = num * 10 + x % 10;
            x /= 10;
        }
        return num;
    }
}
