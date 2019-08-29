


class Solution198 {
    /**
     * Optimized DP method, without visited map.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a graph. Which could be topological sorted.
     *     2. State transition equation: f[i] = max(f[i - 2] + nums[i], f[i - 1]), which means
     *        `i as a tail` or `i not as a tail`.
     *     3. How to handle input `nums.length == 0` and `nums.length == 1`?
     *
     * Time:  O(n), the graph only has `n` nodes, for loop takes `n`
     * Space: O(1)
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prev = 0;           // node i == -1
        int next = nums[0];     // node i == 0
        for (int i = 1; i < nums.length; i++) {
            int cur = Math.max(prev + nums[i], next);
            prev = next;
            next = cur;
        }
        return next;
    }
}
