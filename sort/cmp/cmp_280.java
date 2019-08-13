


class Solution280 {
    /**
     * Case Analysis:
     *     1. i % 2 == 1 && a[i - 1] > a[i]; ---> swap(i - 1, i);
     *        Notes: now a[i - 2] >= a[i - 1] is valid, after swap,  a[i - 2] >= a[i - 1] still valid.
     *     2. i % 2 == 0 && a[i - 1] < a[i]; ---> swap(i - 1, i);
     *        Notes: now a[i - 2] <= a[i - 1] is valid, after swap,  a[i - 2] <= a[i - 1] still valid.
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public void wiggleSort(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i - 1] > nums[i] || i % 2 == 0 && nums[i - 1] < nums[i]) {
                swap(nums, i - 1, i);
            }
        }
    }
    
    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
