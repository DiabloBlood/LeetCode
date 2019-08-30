


class Solution62 {
    /**
     * Optimized DP method with only 1-D visited map.
     * 
     * Problem Analysis:
     *     1. Sub problem f(i, j) is the unique paths from (0, 0) to point (i, j)
     *     2. State transition function is `f(i, j) = f(i - 1, j) + f(i, j - 1)`.
     *     3. Corner case m == 1, n == 1 should return 1.
     *
     * Time:  O(m * n), the graph has `m * n` nodes, for loop takes `m * n`.
     * Space: O(m), 1-D visited map size is `m`.
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] prev = new int[m];
        Arrays.fill(prev, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prev[j] = prev[j] + prev[j - 1];
            }
        }
        return prev[m - 1];
    }

    /**
     * DP method with 2-D visited map.
     * 
     * Problem Analysis:
     *     1. Sub problem f(i, j) is the unique paths from (0, 0) to point (i, j)
     *     2. State transition function is `f(i, j) = f(i - 1, j) + f(i, j - 1)`.
     *     3. Corner case m == 1, n == 1 should return 1.
     *
     * Time:  O(m * n), the graph has `m * n` nodes, for loop takes `m * n`.
     * Space: O(m * n), 2-D visited map size is `m * n`.
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[n][m];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}
