


public class Solution209 {
    /**
     * Notes:
     *     1. `s` is positive integer.
     *     2. All elements of `nums` are integers.
     *
     * Problem Analysis:
     *     1. Define f(x, i) is the smallest range [x, i] which makes f(x, i) >= s.
     *        If we use a for loop count sum[0->i] every time, then for every `i`,
     *        find f(x, i) based on sum[0->i] need avg O(i) time, which will lead to
     *        the final time complexity at O(0.25n^2) level.
     *     2. If use sliding window method, if at `i1` there is sum[0->i1] >= s, then
     *        find f(x, i1), assume x = k, then sum[k->i1] >= s is valid and `i - k + 1`
     *        is the current smallest range, after record `i - k + 1` to `min`, `j` will
     *        be moved to k+1, then when the next time we find sum[k+1->i2] >= s, we can
     *        prove that for `i2`, doesn't need to concer any elements at range [0, k],
     *        since for f(x, i2), x must in [k+1, i2]. Then for every element, at least
     *        been add one time and remove one time, so the time complexity is O(n).
     *
     * General Cases:
     *     1. sum <  s; ---> // do nothing
     *     2. sum >= s; ---> while loop: min = Math.min(i - j + 1, min); sum -= nums[j++];
     *
     * Corner Cases:
     *     1. nums == null; ---> // otherwise `i < nums.length;` will throw `NullPointerException`.
     *     2. s <= 0; ---> // pre-condition is s > 0, this case cannot be handled, which will lead to j > i
     *                        and if -s > sum[0->n-1], finally `j` will out of bound.
     *     3. elements in nums < 0; ---> // cannot be handled, which makes `sum` is not monotonic ascending,
     *                                      will lead to j > i
     *     4. s > sum[0->n-1]; ---> // doesn't need to handle, while loop will be always skipped and finally
     *                                 `min` is Integer.MAX_VALUE
     *     5. nums.length == 0; ---> // doesn't need to handle, for loop will skipped and finally
     *                                 `min` is Integer.MAX_VALUE
     *
     * Time:  O(n), between `n ~ 2n`, for every element, at least been add one time and remove one time.
     * Space: O(1)
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(i - j + 1, min);
                sum -= nums[j++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * O(n^2) method.
     *
     * Problem Analysis:
     *     1. Define f(x, i) is the smallest range [x, i] which makes f(x, i) >= s.
     *
     * Time:  O(0.25n^2)
     * Space: O(1)
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            int sum = total;
            int j = 0;
            while (sum >= s) {
                min = Math.min(i - j + 1, min);
                sum -= nums[j++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
