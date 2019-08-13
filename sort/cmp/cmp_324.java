


class Solution324 {
    /**
     * A trivial method which used coordinates transformation.
     * 
     * Problem pitfall:
     *    1. Consider input [4, 5, 5, 6], a[0] < a[1] == a[2] < a[3].
     *       1). For a[0] < a[1] < a[2] < a[3], 0213 order is valid, 1302 order is valid too.
     *       2). For a[0] < a[1] == a[2] < a[3], 0213 order is wrong, however 1302 order is still valid.
     *
     * Time:  O(n*logn)
     * Space: O(n)
     */
    public void wiggleSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        int m = (n - 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        
        for (int i = 0; i < n; i++) {
            int j = i <= m ? (m - i) * 2 : (n - 1 - i) * 2 + 1;
            nums[j] = copy[i];
        }
    }
    /**
     * A trivial method.
     * 
     * Problem pitfalls:
     *    1. Consider input [4, 5, 5, 6], a[0] < a[1] == a[2] < a[3].
     *       1). For a[0] < a[1] < a[2] < a[3], 0213 order is valid, 1302 order is valid too.
     *       2). For a[0] < a[1] == a[2] < a[3], 0213 order is wrong, however 1302 order is still valid.
     *
     * Time:  O(n*logn)
     * Space: O(n)
     */
    public void wiggleSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        int m = (n - 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);

        for (int i = m, j = 0; i >= 0; i--, j += 2) {
            nums[j] = copy[i];
        }
        for (int i = n - 1, j = 1; i > m; i--, j += 2) {
            nums[j] = copy[i];
        }
    }
}
