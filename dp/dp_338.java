


class Solution338 {
    /**
     * Optimized DP method, without visited map.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a graph. Which could be topological sorted.
     *     2. State transition equation: f[i] = f[i / 2] + i % 2.
     *     3. How to handle input `num == 0` and `num < 0`?
     *     4. Java bit operators priority is very low, that's why `i & 1` need parenthesis.
     *
     * Time:  O(n), the graph only has `n` nodes, for loop takes `n`
     * Space: O(1)
     */
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        }
        int[] result = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
