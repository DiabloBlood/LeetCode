


class Solution153 {
    /**
     * Problem Pre-Condition:
     *    1. This array is sorted in `ascending` order and rotated at some pivot.
     *    2. No duplicates in this array.
     * 
     * Solution Analysis:
     *    1. Find the smallest `index` which satisfy `nums[index] <= tail`, `tail` is `nums[n - 1]`.
     *    2. If no duplicates in this array, this search problem has a unique solution.
     * 
     * Time:  O(logn)
     * Space: O(1)
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
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