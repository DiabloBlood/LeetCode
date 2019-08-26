


class Solution34 {
    /**
     * Problem Analysis:
     *     1. Use `BinarySearchAsc.java` template 2 to find lower bound.
     *     2. Use `BinarySearchAsc.java` template 4 to find upper bound.
     *
     * Problems Pitfalls:
     *     1. Find `start` need to handle `nums[mid] == target` case and `nums[mid] > target` separate since maybe target is not exist.
     *     2. If `start` is not found, return directly, then find `end` could handle cases together.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        int start = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (start == -1) {
            return new int[]{-1, -1};
        }
        right = nums.length - 1;
        int end = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                end = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{start, end};
    }
}
