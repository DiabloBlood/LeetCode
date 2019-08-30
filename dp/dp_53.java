


class Solution53 {
    /**
     * DP method without visited map.
     *
     * Problem Analysis:
     *     1. Assume max sub array start index is `i`, end index is `j`,
     *        then if nums[i : j] is the max sub array of nums[0 : n - 1],
     *        it also must be the max sub array of nums[0:j], where j as end.
     *        proof:
     *            (1). nums[i : j] >= nums[0:0], nums[0:1] ... nums[0:n] ... nums[n - 1 : n - 1]
     *            (2). Then must have nums[i : j] >= nums[0:0], nums[0:1] ... nums[0:j] ... nums[j:j]
     *        So when we find all the max sub array of nums[0:k] (0 <= k <= n - 1) that nums[k] must as the end,
     *        finally we must will find the max sub array of nums[0:j], which is nums[i:j], and nums[i:j] is also
     *        the max sub array of nums[0: n - 1].
     *     2. Sub problem f(i) means maxSubArray of nums[0 : i] that nums[i] must as the end.
     *     3. State transition function: f(i) = nums[i] + f(i - 1) > 0 ? f(i - 1) : 0;
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return Integer.MIN_VALUE;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;    // node i == -1, the max sub array of nums[0:-1];
        
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + (sum > 0 ? sum : 0);
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * DP method with visited map.
     *
     * Problem Analysis:
     *     1. Assume max sub array start index is `i`, end index is `j`,
     *        then if nums[i : j] is the max sub array of nums[0 : n - 1],
     *        it also must be the max sub array of nums[0:j], where j as end.
     *        proof:
     *            (1). nums[i : j] >= nums[0:0], nums[0:1] ... nums[0:n] ... nums[n - 1 : n - 1]
     *            (2). Then must have nums[i : j] >= nums[0:0], nums[0:1] ... nums[0:j] ... nums[j:j]
     *        So when we find all the max sub array of nums[0:k] (0 <= k <= n - 1) that nums[k] must as the end,
     *        finally we must will find the max sub array of nums[0:j], which is nums[i:j], and nums[i:j] is also
     *        the max sub array of nums[0: n - 1].
     *     2. Sub problem f(i) means maxSubArray of nums[0 : i] that nums[i] must as the end.
     *     3. State transition function: f(i) = nums[i] + f(i - 1) > 0 ? f(i - 1) : 0;
     *
     * Time:  O(n)
     * Space: O(n)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * O(n^2) method.
     *
     * Time:  O(n^2)
     * Space: O(n)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return Integer.MIN_VALUE;
        }
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] sum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] += sum[i - 1] + nums[i - 1];
        }        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                max = Math.max(max, sum[j + 1] - sum[i]);
            }
        }
        return max;
    }

    /**
     * The most stupid method.
     *
     * Time:  O(n^3)
     * Space: O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return Integer.MIN_VALUE;
        }
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
