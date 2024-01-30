class Solution {
    /**
     * Problem pitfalls:
     *    1. nums[i] ≠ nums[i+1] is very important. Then we could only handle `>` and `<` cases.
     *    2. If duplicates exist, find solution cannot been guaranted. E.g. [1, 2, 2].
     *
     * Case Analysis:
     *     1. mid == 0                             && mid == n - 1;                             ---> return mid; // which means nums.length == 1
     *     2. mid == 0                             && mid < n - 1 && nums[mid] > nums[mid + 1]; ---> return mid;
     *     3. mid > 0 && nums[mid - 1] < nums[mid] && mid == n - 1;                             ---> return mid;
     *     4. mid > 0 && nums[mid - 1] < nums[mid] && mid < n - 1 && nums[mid] > nums[mid + 1]; ---> return mid;
     *
     *     5. mid == 0                             && mid < n - 1 && nums[mid] < nums[mid + 1]; ---> left = mid + 1;
     *     6. mid > 0 && nums[mid - 1] < nums[mid] && mid < n - 1 && nums[mid] < nums[mid + 1]; ---> left = mid + 1;
     *     7. mid > 0 && nums[mid - 1] > nums[mid] && mid == n - 1;                             ---> right = mid - 1;
     *     8. mid > 0 && nums[mid - 1] > nums[mid] && mid < n - 1 && nums[mid] > nums[mid + 1]; ---> right = mid - 1;
     *     9. mid > 0 && nums[mid - 1] > nums[mid] && mid < n - 1 && nums[mid] < nums[mid + 1]; ---> go left or right;
     * Combined Cases:
     *     1. (mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n - 1 || nums[mid] > nums[mid + 1])
     *       ---> return mid // combine 1234
     *     2. mid > 0 && nums[mid - 1] > nums[mid];     ---> right = mid - 1; // combine 789
     *     3. mid < n - 1 && nums[mid] < nums[mid + 1]; ---> left = mid + 1;  // combine 56
     *
     * Time:  O(logn)
     * Space: O(1)
     */
     public int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * One Pass method.
     * Case Analysis:
     *     1. nums[i] > nums[i + 1]; ---> return i;
     *     2. nums[i] < nums[i + 1]; ---> i++;
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
