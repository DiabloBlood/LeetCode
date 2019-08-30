


class Solution64 {
    /**
     * Optimized DP method with only 1-D visited map.
     * 
     * Problem Analysis:
     *     1. Sub problem f(i, j) is minimum path sum from (0, 0) to point (i, j)
     *     2. State transition function is `f(i, j) = grid[i][j] + min(f(i - 1, j) + f(i, j - 1))`.
     *
     * Time:  O(m * n), the graph has `m * n` nodes, for loop takes `m * n`.
     * Space: O(n), 1-D visited map size is `n`.
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        int[] prev = new int[n];
        prev[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            prev[j] = prev[j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            prev[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                prev[j] = grid[i][j] + Math.min(prev[j], prev[j - 1]);
            }
        }
        return prev[n - 1];
    }

    /**
     * DP method with 2-D visited map.
     * 
     * Problem Analysis:
     *     1. Sub problem f(i, j) is minimum path sum from (0, 0) to point (i, j)
     *     2. State transition function is `f(i, j) = grid[i][j] + min(f(i - 1, j) + f(i, j - 1))`.
     *
     * Time:  O(m * n), the graph has `m * n` nodes, for loop takes `m * n`.
     * Space: O(m * n), 2-D visited map size is `m * n`.
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
