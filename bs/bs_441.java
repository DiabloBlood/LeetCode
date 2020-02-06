


class Solution441 {
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs2` template.
     *
     * Problem Analysis:
     *     1. f(x) = x*(x+1)/2, find the largest x value such that `f(x) <= n`.
     *     1. Initialize pos as `0`, since if n == 0, return value should be `0`.
     *     2. For `(long)mid * (mid + 1) / 2 <= n`, the reason of forcing type cast of `mid` is to aviod
     *        integer overflow. If not cast to long type, it is may such that `mid * (mid + 1) / 2 <= n`,
     *        but the real situation is `(long)mid * (mid + 1) / 2 > n`.
     *
     * Corner Cases:
     *     1. n <  0; ---> return 0; // which means no rows, may throw IllegalArgumentException()
     *                                  if this is an invalid input.
     *     2. n == 0; ---> return 0; // no coins means no rows.
     *     3. n == 1; ---> // doesn't need to handle, return value is `1`.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        int pos = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * (mid + 1) / 2 <= n) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }    
}
