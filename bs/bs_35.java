


class Solution35 {
    /**
     * Problem Analysis:
     *     1. Same to `BinarySearchAsc.java` template 4.
     *     2. Given an ascending array `nums`, a integer `target`,
     *        find the postion with smallest value such that `f(x) >= target`.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int pos = nums.length;
        int right = pos - 1;
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
