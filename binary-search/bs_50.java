


class Solution50 {
    /**
     * Problem Pre-conditions:
     *     1. -100.0 < x < 100.0
     *     2. n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
     *
     * Problem Pitfalls:
     *     1. How to handle corner case n == 0?
     *     2. Case n < 0, x^n = 1 / x^(-n);
     *     3. Case n = -2147483648, `-n` will lead to integer overflow.
     *     4. Consider why the follow solution still could pass if don't chech `n == Integer.MIN_VALUE`?
     *
     * Time:  O(logn)
     * Space: O(logn)
     */
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        return n >= 0 ? helper(x, n) : 1 / helper(x, -n);
    }
    
    private double helper(double x, int n) {
        if (n == 0) {
            return 1.0;
        } 
        double left = helper(x, n / 2);
        double right = n % 2 == 0 ? left : left * x;
        return left * right;
    }
}
