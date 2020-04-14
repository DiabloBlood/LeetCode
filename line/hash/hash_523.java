


public class Solution523 {
    /**
     * Notes:
     *     1. The length of the array won't exceed 10,000.
     *     2. You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
     *     3. Input is a list of non-negative numbers.
     *
     * Problem Analysis:
     *     1. Use a hashmap to store previous remain `sum % k`, then when you find same remain again, the subarray sum
     *        must a multiple to `k`.
     *     2. The input array is non-negative numbers or any integers is doesn't matter. Which means the sums function
     *        doesn't need to be monotonic.
     *
     * Initialization:
     *     1. map.put(0, -1); ---> // which represents sums[0] (sums array), sum[0 -> -1], `-1` is the index. when use hashmap,
     *                                you can define sums[-1]. Otherwise if sum[0 -> i] is multiple of `k`, we cannot use condition
     *                                `i - map.get(remain) >= 2` to check.
     *
     * General Cases:
     *     1. map.containsKey(remain) && i - map.get(remain) >= 2; ---> return true;
     *            // Assume map.get(remain) is `j`, then sum[j + 1 -> i] is multiple, len[j + 1 -> i] == i - (j + 1) + 1 == i - j.
     *     2. !map.containsKey(remain) || i - map.get(remain) < 2; ---> map.putIfAbsent(remain, i);
     *            // record the first appeared index is enough, then we could gurantee find the longest subarray.
     *
     * Corner Cases:
     *     1. nums == null; ---> return false; // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. k == 0; ---> remain = sum; // think input likes [1, 2, 0, 0, 0, 3], will return when loop to index 3.
     *     3. k < 0; ---> // doesn't need to handle, all the sum[0 -> i] still could be grouped by remain.
     *
     * Time:  O(n), for loop takes `n`
     * Space: O(n), sums array `n`
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remain = k == 0 ? sum : sum % k;
            // i - (map.get(remain) + 1) + 1 is the length
            if (map.containsKey(remain) && i - map.get(remain) >= 2) {
                return true;
            }
            map.putIfAbsent(remain, i);
        }
        return false;
    }

    /**
     * If use hashmap likes sums array, which means sums[i + 1] == sum[0 -> i]
     *
     * Notes:
     *     1. map.put(0, 0); ---> likes sums[0], which represents sum[0 -> -1]
     *     2. Assume map.get(remain) is `j`, which is sum[0 -> j-1], at loop round `i`, sum is sum[0 -> i],
     *        then sum sum[j -> i] is multiple of `k`, len[j -> i] == i - j + 1 == i - map.get(remain) + 1.
     *     3. map.putIfAbsent(remain, i + 1); ---> // likes sums array, sums[i + 1] == sum[0 -> i].
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remain = k == 0 ? sum : sum % k;
            if (map.containsKey(remain) && i - map.get(remain) + 1 >= 2) {
                return true;
            }
            map.putIfAbsent(remain, i + 1);
        }
        return false;
    }
}
