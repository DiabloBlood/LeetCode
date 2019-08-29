


class Solution70 {
    /**
     * Optimized DP method, without visited map.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a graph. Which could be topological sorted.
     *     2. State transition equation: f[i] = f[i - 1] + f[i - 2]
     *     3. How to handle input `n == 0` or `n == 1`?
     *
     * Time:  O(n), the graph only has `n` nodes, `2n` edges, for loop takes `n`
     * Space: O(1)
     */
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        int prev = 1;   // case i == 0;
        int next = 1;   // case i == 1;
        for (int i = 2; i <= n; i++) {
            int cur = prev + next;  // which means f[i] = f[i - 1] + f[i - 2] 
            prev = next;
            next = cur;
        }
        return next;
    }

    /**
     * DP method with visited map.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a graph. Which could be topological sorted.
     *     2. State transition equation: f[i] = f[i - 1] + f[i - 2]
     *
     * Time:  O(n), the graph only has `n` nodes, `2n` edges, for loop takes `n`
     * Space: O(n), visited map size is `n`
     */
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        int[] visited = new int[n + 1];
        visited[0] = 1;
        visited[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            visited[i] = visited[i - 1] + visited[i - 2];
        }
        return visited[n];
    }

    /**
     * Memorization method.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a graph. Which could be topological sorted.
     *     2. State transition equation: f[i] = f[i - 1] + f[i - 2]
     *
     * Time:  O(n), the graph only has `n` nodes， `2n` edges.
     * Space: O(2n), stack size at most is `n`, visited map size is `n`
     */
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        int[] visited = new int[n + 1];
        return helper(visited, n);
    }
    
    private int helper(int[] visited, int i) {
        if (i == 0 || i == 1) {
            visited[i] = 1;
            return visited[i];
        }
        int node1 = visited[i - 1] == 0 ? helper(visited, i - 1) : visited[i - 1];
        int node2 = visited[i - 2] == 0 ? helper(visited, i - 2) : visited[i - 2];
        visited[i] = node1 + node2;
        return visited[i];
    }

    /**
     * No Memorization method.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a tree instead of a graph. Tree node has duplicate call, low efficient.
     *     2. Leetcode throw `Time Exceed Limit` of this method.
     *
     * Time:  O(2^n), the function call times is the sum fibonacci series, which is `2^n` level.
     * Space: O(n), stack size at most is `n`.
     */
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        return helper(n);
    }
    
    private int helper(int i) {
        if (i == 0 || i == 1) {
            return 1;
        }
        return helper(i - 1) + helper(i - 2);
    }
}
