/**
 * Solution303
 */
class NumArray {

    private int[] sums;

    /**
     * Constructor method.
     *
     * Problem Analysis:
     *     1. Typical range sum problem. Use a sums array with length of nums.length + 1,
     *        follow the left closed right open interval principle, we have some rules as follow,
     *        =>
     *        sums[i + 1] = sum[0 -> i],
     *        sumRange(i, j) = sum[0 -> j] - sum[0 -> i-1] = sums[j + 1] - sums[i],
     *        sums[0] = sum[0 -> -1] == 0, which is just a placeholder that make sure `sumRange(0, j)` always correct.
     *
     * Corner Cases:
     *     1. nums == null; ---> throw new NullPointerException();
     *
     * Time:  O(n), one pass for loop
     * Space: O(n), sums array
     */
    public NumArray(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    /**
     * sumRange method.
     *
     * Corner Cases:
     *     1. i < 0 || i >= sums.length;    ---> throw new IllegalArgumentException(); // `i` out of bound
     *     2. j < 0 || j + 1 > sums.length; ---> throw new IllegalArgumentException(); // `j` out of bound
     *     3. i > j;                        ---> throw new IllegalArgumentException(); // non-valid input
     *
     * Time:  O(1)
     * Space: O(1)
     */
    public int sumRange(int i, int j) {
        if (i < 0 || i >= sums.length || j < 0 || j + 1 >= sums.length || i > j) {
            throw new IllegalArgumentException();
        }
        return sums[j + 1] - sums[i];
    }
}
