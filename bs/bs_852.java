


class Solution852 {
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs9` template.
     *     2. 3 <= nums.length <= 10000
     *     3. 0 <= nums[i] <= 10^6
     *     4. nums is a mountain, so there must be `0 < i < n - 1`.
     *
     * Problem Analysis:
     *     1. Why we doesn't need to consider `ArrayIndexOutOfBoundsException`?
     *        Proof: since 3 <= n <= 10000, then `right` >= 2,
     *            => 1st round: mid > 0 && mid < n - 1;
     *            => 2nd round:
     *               if mid at left slope, then 0 < mid < i < n - 1,
     *               which means n - 1 - mid >= 2, then at 3rd round there must be
     *               (mid + n - 1)/2 <= (2*n-3)/2 = n - 2 < n - 1,
     *               which means mid impossible go to n - 1. So for all the next rounds,
     *               will have mid > 0 && mid < n - 1.
     *               if mid at right slope, then 0 < i < mid < n - 1,
     *               which meand mid >= 2, then at 3rd round there must be
     *               mid / 2 >= 1, which means mid impossible go to 0. So for all the next
     *               round, will have mid > 0 && mid < n - 1.
     *            => so mid - 1 or mid + 1 always valid.
     *
     * General Cases:
     *     1. nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]; ---> return mid;
     *     2. nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]; ---> left = mid + 1;
     *     3. nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]; ---> right = mid - 1;
     *
     * Corner Cases:
     *     1. Since nums.length >= 3, so there is not corner cases.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public int peakIndexInMountainArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
