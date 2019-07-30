


public class Solution extends VersionControl {
    /**
     * Case Analysis:
     * 1. Please see `BinarySearchAsc.bs4` method.
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
