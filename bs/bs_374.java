


class Solution374 {
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs9` template.
     *
     * Corner Cases:
     *     1. n < 1; ---> throw new IllegalArgumentException();; // invalid input
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int guessNumber(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
