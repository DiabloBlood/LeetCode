


public class Solution278{
    /**
     * Notes:
     *     1. Please see `BinarySearchAsc.bs4` method.
     *
     * Problem Analysis:
     *     1. `pos` initialized as `n + 1`. Since if the first bad version is `1`, finally pos is `1`,
     *         if no bad version existed, pos finally will be `n + 1`, which means all versions < n + 1
     *         are good versions.
     *
     * General Cases:
     *     1. isBadVersion(mid);  ---> pos = mid; left = mid + 1; // a potential first bad version found.
     *     2. !isBadVersion(mid); ---> left = mid + 1; // just move left bound since no potentail first bad version found.
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
        int pos = n + 1;
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
