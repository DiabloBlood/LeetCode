

class Solution69 {
    /**
     * Problems Pitfalls:
     *     1. Please note case x = 0 and x = 1.
     *     2. Please note `mid * mid` may lead to integer overflow.
     *     3. `x < 0` could be handled in general case.
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
