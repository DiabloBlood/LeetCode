


class Solution121 {
    /**
     * Optimized DP method, without visited map.
     * 
     * Problem Analysis:
     *     1. Sub problem f(i) is the minimum price of prices[0:i].
     *     2. State transition function is `f(i) = min(prices[i], f(i - 1))`.
     *
     * Time:  O(n), the graph only has `n` nodes, for loop takes `n`.
     * Space: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price: prices) {
            max = Math.max(max, price - min);
            min = Math.min(min, price);
        }
        return max;
    }
    /**
     * DP method with visited map.
     * 
     * Problem Analysis:
     *     1. Sub problem f(i) is the minimum price of prices[0:i]
     *     2. State transition function is `f(i) = min(prices[i], f(i - 1))`.
     *
     * Time:  O(n), the graph only has `n` nodes, for loop takes `n`.
     * Space: O(n), visited map size is `n`.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = prices[0];
        int max = 0;
        
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - dp[i - 1]);
            dp[i] = Math.min(prices[i], dp[i - 1]);
        }
        return max;
    }
}
