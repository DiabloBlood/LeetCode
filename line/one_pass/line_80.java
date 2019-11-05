


class Solution80 {
    /**
     * Key Points:
     *    1. Input array is a sorted array, there must be `nums[end - 2] <= nums[end - 1] <= nums[i]`.
     *
     * Problem Analysis:
     *     1. Result at least is `2` when array contains more than 1 elements.
     *     2. Interval [0, end) is valid.
     *     3. `end` should be the return length.
     *
     * Case Analysis:
     *     1. nums[end - 2] == nums[end - 1] && nums[end - 1] == nums[i]; ---> // do nothing;
     *     2. nums[end - 2] == nums[end - 1] && nums[end - 1] <  nums[i]; ---> nums[end++] = nums[i];
     *     3. nums[end - 2] <  nums[end - 1] && nums[end - 1] == nums[i]; ---> nums[end++] = nums[i];
     *     4. nums[end - 2] <  nums[end - 1] && nums[end - 1] <  nums[i]; ---> nums[end++] = nums[i];
     *     =>
     *     1. nums[end - 2] == nums[i]; ---> // do nothing;
     *     2. nums[end - 2] <  nums[i]; ---> nums[end++] = nums[i];
     *     3. nums[end - 2] <  nums[i]; ---> nums[end++] = nums[i];
     *     4. nums[end - 2] <  nums[i]; ---> nums[end++] = nums[i];
     *     =>
     *     1. nums[end - 2] == nums[i]; ---> // do nothing;
     *     2. nums[end - 2] <  nums[i]; ---> nums[end++] = nums[i];
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int len = nums.length;
        if (len < 3) {
            return len;
        }
        int end = 2;
        for (int i = 2; i < len; i++) {
            if (nums[i] < nums[end - 2]) {
                nums[end++] = nums[i];
            }
        }
        return end;
    }
    /**
     * A more concise method.
     *
     * Case Analysis:
     *     1. end < 2;                  ---> nums[end++] = nums[i];
     *     2. nums[end - 2] == nums[i]; ---> // do nothing;
     *     3. nums[end - 2] <  nums[i]; ---> nums[end++] = nums[i];
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (end < 2 || nums[end - 2] < nums[i]) {
                nums[end++] = nums[i];
            }
        }
        return end;
    }
}
