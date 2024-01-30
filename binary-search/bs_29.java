


class Solution29 {
    /**
     * Problem Pre-conditions:
     *     1. `dividend` and `divisor` is a 32-bit signed integer, within the range [−2^31, 2^31 − 1].
     *
     * Problem Pitfalls:
     *     1. Case [-2147483648, 1], shoud return `2147483647`;
     *     2. Case [2147483647, 1], which lead to second while loop integer overflow. That's why we need long type.
     *  
     * Assume `dividend` is `n`
     * Time:  O(logn)
     * Space: O(1)
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int result = 0;
        while (dvd >= dvs) {
            int times = 1;
            long temp = dvs;
            while (dvd > temp << 1) {
                temp <<= 1;
                times <<= 1;
            }
            dvd -= temp;
            result += times;
        }
        return sign * result;
    }
}
