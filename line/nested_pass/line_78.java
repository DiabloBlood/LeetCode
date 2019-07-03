


class Solution78 {
    /**
     * Notes: what's mean not distict elements?
     * How many subsets? C(n, 0) + C(n, 1) +...+ C(n, k) +...+ C(n, n) = 2^n. (Binomial Theorem)
     * Use formula: k * C(n, k) = n * C(n - 1, k - 1)
     * Total Elements: 1 * C(n, 1) +...+ k * C(n, k) +...+ n * C(n, n)
     *               = n * C(n - 1, 0) +...+ n * C(n - 1, k - 1) +...+  n * C(n - 1, n - 1)
     *               = n * 2^(n-1)
     * Time:  O(2^n), n * 2^(n-1)
     * Space: O(1)
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int len = result.size();
            for (int j = 0; j < len; j++) {
                List<Integer> temp = new ArrayList(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}