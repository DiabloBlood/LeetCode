


public class Solution69 {
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs2` template.
     *
     * Problem Analysis:
     *     1. Initialize pos as `-1`, it's just a return placeholder, for this problem,
     *        finally `pos` must be `>= 0`.
     *     2. For `(long)mid * mid <= x`, the reason of forcing type cast of `mid` is to aviod
     *        integer overflow. If not cast to long type, it is may such that `mid * mid` < x,
     *        but the real situation is `(long)mid * mid > x`.
     *
     * General Cases:
     *     1. (long)mid * mid <= x; ---> pos = mid; left = mid + 1; // a potential square root found, move left
     *     2. (long)mid * mid >  x; ---> right = mid - 1; // must not be a square root, move right
     *
     * Corner Cases:
     *     1. x < 0; ---> return -1; // negtive number doesn't has square root, this is an invalid input.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        int left = 0;
        int right = x;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }
}
