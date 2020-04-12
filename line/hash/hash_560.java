


public class Solution560 {
    /**
     * HashMap method.
     *
     * Notes:
     *     1. The length of the array is in range [1, 20,000].
     *     2. The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     *     3. So don't worry about `integer overflow`.
     *     4. Since numbers in array may negative, so the sums function is not monotonic.
     *
     * Problem Analysis:
     *     1. Use a hashmap to track all sum frequencies, when loop at `i` round, use O(1) time find all counts that
     *        sum[0 -> j] == sum - k, where j between [0, i - 1]. So we don't need to loop 0 -> i.
     *
     * Initialization:
     *     1. map.put(0, 1); ---> // which likes the sums[0] of sums array, it represents sum[0 -> -1] appear 1 time,
     *                               otherwise you cannot calculate sum[0 -> i], since it's need sum[0 -> i] - sum[0 -> -1].
     *
     * General Cases:
     *     1. map.containsKey(sum - k); ---> count += map.get(sum - k);
     *
     * Corner Cases:
     *     1. nums == null; ---> return 0; // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip for loop and finally return `0`.
     *
     * Time:  O(n), for loop takes `n`
     * Space: O(n), hashmap takes `n`
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);    // likes sums[0]
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];    // likes sums[i + 1]
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * Brute force method.
     *
     * Problem Analysis:
     *     1. Use sums array, sums[i + 1] = sum[0 -> i], sum[j -> i] = sum[0 -> i] - sum[0 -> j-1] = sums[i + 1] - sums[j].
     *
     * Initialization:
     *     1. int[] sums = new int[n + 1]; ---> // build left close right open interval sums array, sums[i + 1] = sum[0 -> i],
     *                                             likes `substring` method.
     *     2. j <= i; ---> // loop sum[0 -> i], sum[1 -> i], ... sum[i -> i]
     *
     * General Cases:
     *     1. sums[i + 1] = sums[i] + nums[i]; ---> // standard method to build a sums array.
     *     2. sums[i + 1] - sums[j] == k; ---> count++; // standard calculate sum[j -> i].
     *
     * Corner Cases:
     *     1. nums == null; ---> return 0; // otherwise `int n = nums.length;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip 1st and 2nd for loop and finally return `0`.
     *
     * Time:  O(0.5n^2), nested for loops takes `0.5n^2`
     * Space: O(n), sums array takes `n`
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (sums[i + 1] - sums[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
