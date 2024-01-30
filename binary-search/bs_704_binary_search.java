


class Solution704 {
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs9` template.
     *
     * Corner Cases:
     *     1. nums == null; ---> return -1; // otherwise `int right = nums.length - 1;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> // doesn't need to handle, will skip while loop and directly return `-1`.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
