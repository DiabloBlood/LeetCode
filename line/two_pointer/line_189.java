


public class Solution189 {
   /**
    * Problem Analysis:
    *     1. Reverse [0, n - 1] first, then reverse [0, k - 1] and [k, n - 1].
    *     2. If k >= nums.length, the effect is equal to rotate `k % n` steps.
    *     3. If without code `k = k % n;`, code `reverse(nums, 0, k - 1);` will throw
    *        `ArrayIndexOutOfBoundException` when k > n.
    *
    * Corner Cases:
    *     1. nums == null;     ---> return; // otherwise `int n = nums.length;` will throw `NullPointerException`
    *     2. nums.length == 0; ---> return; // otherwise `k = k % n;` will throw `ArithmeticException: divide by zero`
    *     3. k < 0;            ---> return; // this is a invalid input, otherwise `reverse(nums, k, n - 1);` will
    *                                          throw `ArrayIndexOutOfBoundException`
    *     4. k % n == 0;       ---> // if not handle, finally result is valid, but need extra `2n` time, reverse array 2 times.
    *
    * Time:  O(2n), first reverse takes `n`, 2nd and 3rd reverse totally takes `n`.
    * Space: O(1)
    */ 
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0 || k % nums.length == 0) {
            return;
        }
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
 
    /**
     * A stupid and trivial method
     *
     * Time:  O(nk)
     * Space: O(1)
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0 || k % nums.length == 0) {
            return;
        }
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
