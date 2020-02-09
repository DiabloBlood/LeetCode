


public class Solution278 {
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs4` template.
     *
     * Problem Analysis:
     *     1. Initialize pos as `-1`, if no first bad version found (which means all versions are good), shoud return `-1`.
     *     2. Assume input is [0, 0, 0, 0, 1, 1, 1], `0` means isBadVersion return false, `1` means return true, then problem
     *        likes find smallest position such that `f(x) >= 1`
     *
     * General Cases:
     *     1. isBadVersion(mid);  ---> pos = mid; left = mid + 1; // a potential first bad version found.
     *     2. !isBadVersion(mid); ---> left = mid + 1; // just move left bound since no potentail first bad version found.
     *
     * Corner Cases:
     *     1. n < 1; ---> return -1; // this is an invalid input, need to check and handle.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int firstBadVersion(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int left = 1;
        int right = n;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }
}
