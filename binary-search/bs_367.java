


class Solution367 {
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs9` template.
     *     2. Input is a positive number is a pre-condition,
     *        so `0` doesn't count as perfect square numbers.
     *
     * Problem Analysis:
     *     1. For `int square = (long)mid * mid;`, the reason of forcing type cast of `mid` is to aviod
     *        integer overflow. If not cast to long type, it is may such that `mid * mid < num`,
     *        but the real situation is `(long)mid * mid > num`.
     *
     * Corner Cases:
     *     1. num < 1; ---> return false; // negtive number and `0` doesn't count as perfect square numbers.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long)mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
