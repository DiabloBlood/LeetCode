


public class Solution78 {
    /**
     * Notes: what's mean not distict elements?
     * How many subsets? C(n, 0) + C(n, 1) +...+ C(n, k) +...+ C(n, n) = 2^n. (Binomial Theorem)
     * Use formula: k * C(n, k) = n * C(n - 1, k - 1)
     * Total Elements: 1 * C(n, 1) +...+ k * C(n, k) +...+ n * C(n, n)
     *               = n * C(n - 1, 0) +...+ n * C(n - 1, k - 1) +...+  n * C(n - 1, n - 1)
     *               = n * 2^(n-1)
     * Time:  O(n*2^n), n * 2^(n-1) times operations
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

    /**
     * Notes: what's mean not distict elements?
     * How many subsets? C(n, 0) + C(n, 1) +...+ C(n, k) +...+ C(n, n) = 2^n. (Binomial Theorem)
     * Use formula: k * C(n, k) = n * C(n - 1, k - 1)
     * Total Elements: 1 * C(n, 1) +...+ k * C(n, k) +...+ n * C(n, n)
     *               = n * C(n - 1, 0) +...+ n * C(n - 1, k - 1) +...+  n * C(n - 1, n - 1)
     *               = n * 2^(n-1)
     * Time:  O(n*2^n), n * 2^(n-1) times copy, 2^n list add, 2^n list remove
     * Space: O(2n), O(n) for implicit stack, O(n) for template list.
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), result, 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, list, result, i + 1);
            // remove last element
            list.remove(list.size() - 1);
        }
    }
}
