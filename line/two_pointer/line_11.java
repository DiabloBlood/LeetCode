


public class Solution11 {
    /**
     * Problem Analysis:
     *     1. The key point is for any point `i`, we doesn't need to brute force check all points in [i + 1, n - 1] one by one,
     *        when the first `j` found that h[i] < h[j], all points in [i + 1, j - 1] doesn't need to check.
     *
     * General Cases:
     *     1. h[i] <  h[j]; ---> record (j - i) * h[i]; i++; // i with any line in [i + 1, j - 1] is impossible larger than `(j - i) * h[i]`.
     *     2. h[i] >= h[j]; ---> record (j - i) * h[j]; j--; // j with any line in [i + 1, j - 1] is impossible larger than `(j - i) * h[j]`.
     *
     * Corner Cases:
     *     1. h == null; ---> return 0; // otherwise `int j = h.length - 1;` will throw `NullPointerException`.
     *     2. h.length < 2; ---> // non valid input
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public int maxArea(int[] h) {
        if (h == null || h.length < 2) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int i = 0;
        int j = h.length - 1;
        while (i < j) {
            int area = h[i] < h[j] ? (j - i) * h[i++] : (j - i) * h[j--];
            result = Math.max(result, area);
        }
        return result;
    }

    /**
     * Brute force method.
     *
     * Time:  O(0.5n^2)
     * Space: O(1)
     */
    public int maxArea(int[] h) {
        if (h == null || h.length < 2) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int n = h.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = (j - i) * Math.min(h[i], h[j]);
                result = Math.max(result, area);
            }
        }
        return result;
    }
}
