


class Solution35 {
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs4` template.
     *     2. You may assume no duplicates in the array, this is a pre-condition.
     *
     * Problem Analysis:
     *     1. If array has duplicates, e.g. [arrays is 1, 3, 5, 5, 5, 6], target = 5,
     *        then output is 2, the first occurrence of duplicate number.
     *
     * Corner Cases:
     *     1. nums == null; ---> return -1; // -1 is a impossible insert postion.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }
}
