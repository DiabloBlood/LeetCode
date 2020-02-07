


class Solution153 {
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs4` template.
     *     2. This array is sorted in `ascending` order and rotated at some pivot.
     *     3. No duplicates in this array.
     * 
     * Problem Analysis:
     *     1. Find the smallest `index` such that `nums[index] <= tail`, `tail` is `nums[n - 1]`.
     *        Even though rotated array `f(index) = value` is not a monofonic function, however,
     *        `f(x) = nums[x] <= tail` is a monofonic function, for example, for input array
     *        [4, 5, 6, 7, 1, 2, 3], f(x) value space is [0, 0, 0, 0, 1, 1, 1], which is likes
     *        find the smallest position value such that `f(x) >= 1`.
     *     2. If no duplicates in this array, this search problem has a unique solution.
     *
     * Corner Cases:
     *     1. nums == null; ---> return -1; // if not handle `int right = nums.length - 1;` will throw `NullPointerException`.
     *     2. nums.length == 0; ---> return -1; // if not handle `int tail = nums[right];` will throw `ArrayIndexOutOfBoundsException`.
     *     3. If array is not rotated, '0' will been returned. So `pos = -1` is just a place holder, finally pos absolutelly will >= 0,
     *        so we don't need to worry `return nums[pos];` out of bound issue.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int tail = nums[right];
        int pos = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= tail) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[pos];
    }
}
