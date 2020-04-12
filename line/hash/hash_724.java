


public class Solution724 {
    /**
     * Standard range sum question
     *
     * Notes:
     *     1. The length of nums will be in the range [0, 10000]
     *     2. Each element nums[i] will be an integer in the range [-1000, 1000]
     *     3. So don't worry about `integer overflow`.
     *     4. Since numbers in array may negative, so the sums function is not monotonic.
     *     5. If `i == 0`, the left sum is sum[0 -> -1] == 0.
     *     6. If `i == n - 1`, the right sum is sum[n -> n-1] == 0.
     *
     * Problem Analysis:
     *     1. Use standard sums array.
     *
     * General Cases:
     *     1. sums[i] - sums[0] == sums[n] - sums[i + 1]; ---> return i; // sum[0 -> i-1] == sum[i+1 -> n-1]
     *
     * Corner Cases:
     *     1. nums == null; ---> return -1; // otherwise `int n = nums.length;` will throw `NullPointerException`.
     *     2. i == 0;       ---> // left sum sum[0 -> i-1] == sum[0 -> -1] == sums[i] - sums[0] == sums[0] - sums[0] == 0;
     *     3. i == n - 1;   ---> // right sum sum[i+1 -> n-1] == sum[n -> n-1] == sums[n] - sums[n] == 0;
     *
     * Time:  O(2n), build sums array takes `n`, 2nd for loop takes `n`
     * Space: O(n), sums array `n`
     */
    public int pivotIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            // sum[0 -> i-1] == sum[i+1 -> n-1]
            if (sums[i] - sums[0] == sums[n] - sums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
