


public class Solution27 {
    /**
     * Problem Analysis:
     *     1. Interval [0, end) is valid, which means elements in range `a[0] --> a[end - 1]` not equal to val.
     *     2. if a[i] != val, which means next valid number found.
     *     3. `end` should be the return length.
     *
     * Case Analysis:
     *     1. a[i] != val; ---> a[end++] = a[i];
     *     2. a[i] == val; ---> // do nothing
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return -1;
        }
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[end++] = nums[i];
            }
        }
        return end;
    }
}
