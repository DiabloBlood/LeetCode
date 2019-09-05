


class Solution322 {
    /**
     * Optimized DP method, visited map is necessary.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a graph. Which could be topological sorted.
     *     2. Corner case `coins == null`, should return `-1`;
     *     3. Corner case `coins.length == 0`, should return `-1`;
     *     4. Corner case `amount == 0`, should return `0`, which mean 0 coins.
     *
     * Time:  O(m * n), the graph only has `n` nodes, `m * n` edges.
     * Space: O(n)
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
        int[] visited = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (i >= coin && visited[i - coin] != -1) {
                    int count = visited[i - coin] + 1;
                    min = Math.min(min, count);
                }
            }
            visited[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return visited[amount];
    }

    /**
     * Memorization method.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a graph. Which could be topological sorted.
     *     2. Corner case `coins == null`, should return `-1`;
     *     3. Corner case `coins.length == 0`, should return `-1`;
     *     4. Corner case `amount == 0`, should return `0`, which mean 0 coins.
     *
     * Assume coins.length == `m`, amount is `n`
     * Time:  O(m * n), the graph only has `n` nodes, `m * n` edges.
     * Space: O(2n), stack size at most is `n`, visited map size is `n`.
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
        return helper(new int[amount + 1], coins, amount);
    }
    
    private int helper(int[] visited, int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (visited[amount] != 0) {
            return visited[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            int count = helper(visited, coins, amount - coin);
            if (count >= 0 && count < min) {
                min = count + 1;
            }
        }
        visited[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return visited[amount];
    }

    /**
     * No Memorization method.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a tree instead of a graph. Tree node has duplicate call, low efficient.
     *     2. The path with minimum depth may not the leftmost valid tree-leaf path. E.g. case [7, 6, 1], amount 24
     *     3. Leetcode throw `Time Exceed Limit` of this method.
     * 
     * Assume coins.length == `m`, amount is `n`
     * Time:  O(m^n), the function call times is exponential level.
     * Space: O(n), the most deep stack depth is `n / min(num in coins)`.
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
        return helper(coins, amount);
    }
    
    private int helper(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int count = helper(coins, amount - coins[i]);
            if (count >= 0 && count < min) {
                min = count + 1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
