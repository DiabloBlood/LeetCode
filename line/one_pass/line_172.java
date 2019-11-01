


public class Solution12 {
    /**
     * Problem Analysis:
     *     1. We can factorize or decompose a factorial to just prime factors.
     *     2. Consider `5!`, which equivalent to `2^3 * 3 * 5`, since `4` could factorize to `2^2`.
     *     3. Consider `11!`, which equivalent to `2^8 * 3^4 * 5^2 * 7^1 * 11^1`.
     *     4. A trailing zero is always produced by prime number `2` and `5`.
     *     5. We can easily observe that count of `2` in prime factors is always more than or equal to count of `5` in prime factors.
     *     6. The quotient of `n / 5` is the count of `5` in prime factors.
     *     7. total of `5`s = `floor(n / 5) + floor(n / 25) + floor(n / 125) + flow(n / 625) +...`.
     *     8. => `n / 5^2 + n / 5^3 + n /5^4 +...`.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int trailingZeroes(int n) {
        // Please note that the defination of `0!` is `1`.
        if (n < 1) {
            return 0;
        }
        int count = 0;
        while (n > 0) {
            int quot = n / 5;
            count += quot;
            n = quot;
        }
        return count;
    }
}
