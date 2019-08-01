


class Solution88 {
    /**
     * Case Analysis:
     *     1. idx1 >= 0 && idx2 >= 0 && nums1[idx1] > nums2[idx2]; nums1[idx] = nums1[idx1];
     *     2. idx1 >= 0 && idx2 >= 0 && nums1[idx1] <= nums2[idx2]; nums1[idx] = nums2[idx2];
     *     3. idx1 >= 0 && idx2 < 0; // do nothing `nums1[idx] = nums1[idx1]` is not necessary.
     *     4. idx1 < 0 && idx2 >= 0; nums1[idx] = nums2[idx2];
     *     5. idx1 < 0 && idx2 < 0; // do nothing
     * Only need to take care case 1, 2, 4.
     *
     * Time: Best  O(n)
     *       Worst O(m + n)
     * Space: O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int idx = m + n - 1;
        while (idx2 >= 0) {
            nums1[idx--] = idx1 >= 0 && nums1[idx1] > nums2[idx2] ? nums1[idx1--] : nums2[idx2--];
        }
    }
}
