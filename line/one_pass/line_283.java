


public class Solution283 {
    /**
     * Problem Analysis:
     *     1. Interval [0, end) is valid, which means elements in range `a[0] --> a[end - ]` is not 0.
     *     2. if case `a[i] != 0`, which means next valid number found.
     *     3. Finally assign `0` to range `a[end] --> a[len - 1]`.
     *
     * Case Analysis:
     *     1. a[i] != 0; ---> a[end++] = a[i];
     *     2. a[i] == 0; ---> // do nothing
     *
     * Time:  O(n), worst case is O(2n), when array is all 0s.
     * Space: O(1)
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[end++] = nums[i];
            }
        }
        while (end < nums.length) {
            nums[end++] = 0;
        }
    }

    /**
     * One pass solution.
     *
     * Key Points:
     *     1. Please refer to prinston quick sort method.
     *
     * Case Analysis:
     *     1. Interval [0, end) contains numbers which != 0.
     *     2. Interval [end, i) contains 0.
     *
     * Time:  O(n), only one pass. But please note swap is O(3), expensive than other O(1) operations.
     * Space: O(1).
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, end++, i);
            }
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
