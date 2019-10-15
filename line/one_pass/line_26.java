


public class Solution26 {
    /**
     * Key Points:
     *     1. This a sorted array, if this array is not sorted, either use hashmap or sort this array first.
     *
     * Problem Analysis:
     *     1. [0, end) is valid
     *     2. if `a[i] > a[end - 1]`, which means next larger number found.
     *     3. `end` should be return length.
     *
     * Case Analysis:
     *     1. a[i] >  a[end - 1]; ---> a[end++] = a[i]
     *     2. a[i] == a[end - 1]; ---> // do nothing
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int end = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[end - 1]) {
                nums[end++] = nums[i];
            }
        }
        return end;
    }
}
