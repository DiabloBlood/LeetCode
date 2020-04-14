


public class Solution974 {
    /**
     * Notes:
     *     1. 1 <= A.length <= 30000
     *     2. -10000 <= A[i] <= 10000, so the sums function is not monotonic.
     *     3. 2 <= K <= 10000, `K` cannot be `0`.
     *
     * Problem Analysis:
     *     1. Please refer problem 523.
     *     2. Use a hashmap group sum[0 -> i], store remain `sum % k` as key, frequency as value.
     *     3. If remain is negative, normalize it to a positive number.
     *
     * Initialization:
     *     1. map.put(0, 1); ---> // which represents sums[0] (sums array), sum[0 -> -1], `1` is frequency.
     *
     * General Cases:
     *     1. int key = remain < 0 ? remain + k : remain; ---> // normalize remain if remain is negative.
     *
     * Corner Cases:
     *     1. nums == null; ---> return 0; // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. k == 0; ---> // invalid input, any sum not divisible by `0`
     *     3. k < 0; ---> // doesn't need to handle, all the sum[0 -> i] still could be grouped by remain.
     *
     * Time:  O(n), for loop takes `n`.
     * Space: O(n), hashmap takes `1 ~ n`.
     */
    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || k == 0) {
            return 0;
        }
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += num[i];
            int remain = sum % k;
            int key = remain < 0 ? remain + k : remain;
            int count = map.getOrDefault(key, 0);
            result += count;
            map.put(key, count + 1);
        }
        return result;
    }
}
